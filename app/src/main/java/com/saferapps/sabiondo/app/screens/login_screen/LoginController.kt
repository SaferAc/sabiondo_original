package com.saferapps.sabiondo.app.screens.login_screen

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import android.util.Base64
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import java.security.SecureRandom
import kotlinx.coroutines.CoroutineScope
import androidx.core.net.toUri
import com.saferapps.sabiondo.app.data.repository.AuthRepository
import com.saferapps.sabiondo.helper.SessionHandler

class LoginController(
    private val session: SessionHandler,
    private val repository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(LoginUiState())
    val state = _state.asStateFlow()

    fun onEmailChange(v: String) {
        _state.value = _state.value.copy(
            email = v,
            errorMailVisible = false
        )
    }

    fun onPasswordChange(v: String) {
        _state.value = _state.value.copy(
            password = v,
            errorPasswordVisible = false
        )
    }

    fun login() {
        val email = _state.value.email
        val password = _state.value.password

        if (email.isBlank() ||
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showMailError()
            return
        }

        if (password.isBlank()) {
            showPasswordError()
            return
        }

        viewModelScope.launch {
            try {
                _state.value = _state.value.copy(loading = true)
                val result = repository.login(email, password)
                
                session.loginUser(
                    result.name,
                    result.uid,
                    result.role
                )
                _state.value = _state.value.copy(
                    loading = false,
                    loginSuccess = true
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    loading = false,
                    authError = true
                )
                showPasswordError()
                hideAuthErrorLater()
            }
        }
    }

    fun resetLoginSuccess() {
        _state.value = _state.value.copy(
            loginSuccess = false,
            email = "",
            password = "",
            errorMailVisible = false,
            errorPasswordVisible = false,
            authError = false
        )
    }

    private fun hideAuthErrorLater(){
        _state.value = _state.value.copy(authError = true)
        viewModelScope.launch {
            delay(3000)
            _state.value = _state.value.copy(authError = false)
        }
    }

    private fun showMailError() {
        _state.value = _state.value.copy(errorMailVisible = true)
        viewModelScope.launch {
            delay(3000)
            _state.value = _state.value.copy(errorMailVisible = false)
        }
    }

    private fun showPasswordError() {
        _state.value = _state.value.copy(errorPasswordVisible = true)
        viewModelScope.launch {
            delay(3000)
            _state.value = _state.value.copy(errorPasswordVisible = false)
        }
    }

    fun onRoleChange(role: String) {
        _state.value = _state.value.copy(role = role)
    }

    fun onForgotPassword() {
        val email = _state.value.email
        if (email.isBlank() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _state.value = _state.value.copy(
                authError = true,
                error = "Ingresa un correo válido para restablecer tu contraseña"
            )
            hideAuthErrorLater()
            return
        }

        viewModelScope.launch {
            try {
                _state.value = _state.value.copy(loading = true)
                repository.sendPasswordResetEmail(email)
                _state.value = _state.value.copy(
                    loading = false,
                    authError = true, // Usamos esto para mostrar el mensaje de éxito también
                    error = "Se ha enviado un correo para restablecer tu contraseña"
                )
                hideAuthErrorLater()
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    loading = false,
                    authError = true,
                    error = "Error: ${e.message}"
                )
                hideAuthErrorLater()
            }
        }
    }

    fun showError(message: String) {
        _state.value = _state.value.copy(
            authError = true,
            error = message
        )
        hideAuthErrorLater()
    }

    fun onPasswordVisible() {
        _state.value = _state.value.copy(passwordVisible = !_state.value.passwordVisible)
    }

    fun startGoogleSignIn(context: Context, scope: CoroutineScope) {
        val credentialManager = CredentialManager.create(context)
        val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId("619175024507-lliblmqjs2cag9a6us5n472pntncvpor.apps.googleusercontent.com")
            .setAutoSelectEnabled(true)
            .setNonce(generateSecureRandomNonce())
            .build()

        val request: GetCredentialRequest = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        scope.launch {
            try {
                val result = credentialManager.getCredential(
                    request = request,
                    context = context,
                )
                val credential = result.credential
                if (credential is GoogleIdTokenCredential) {
                    onGoogleSignIn(credential.idToken)
                }
            } catch (e: GetCredentialException) {
                showError("Error al conectar con Google: ${e.message}")
            } catch (e: Exception) {
                showError("Ocurrió un error inesperado")
            }
        }
    }

    private fun generateSecureRandomNonce(byteLength: Int = 32): String {
        val randomBytes = ByteArray(byteLength)
        SecureRandom().nextBytes(randomBytes)
        return Base64.encodeToString(randomBytes, Base64.NO_WRAP or Base64.URL_SAFE or Base64.NO_PADDING)
    }

    fun onGoogleSignIn(idToken: String) {
        val role = _state.value.role
        if (role == null) {
            _state.value = _state.value.copy(
                authError = true,
                error = "Selecciona un tipo de usuario antes de continuar"
            )
            hideAuthErrorLater()
            return
        }

        viewModelScope.launch {
            try {
                _state.value = _state.value.copy(loading = true)
                val result = repository.signInWithGoogle(idToken, role)
                session.loginUser(
                    result.name,
                    result.uid,
                    result.role
                )
                _state.value = _state.value.copy(
                    loading = false,
                    loginSuccess = true
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    loading = false,
                    authError = true,
                    error = "Error de autenticación. Verifique sus credenciales."
                )
                hideAuthErrorLater()
            }
        }
    }

    fun onTermsClick(context: Context) {
        val intent = Intent(Intent.ACTION_VIEW, "https://cutt.ly/8yF2Ul7".toUri())
        context.startActivity(intent)
    }

    companion object {
        fun provideFactory(context: Context): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return LoginController(SessionHandler(context)) as T
            }
        }
    }
}
