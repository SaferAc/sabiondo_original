package com.saferapps.sabiondo.app.screens.register

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.saferapps.sabiondo.app.data.repository.AuthRepository
import com.saferapps.sabiondo.helper.SessionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegisterController(
    private val session: SessionHandler,
    private val repository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(RegisterUiState())
    val state = _state.asStateFlow()

    fun onUsernameChange(v: String) {
        _state.value = _state.value.copy(username = v, errorUsername = null)
    }

    fun onEmailChange(v: String) {
        _state.value = _state.value.copy(email = v, errorEmail = null)
    }

    fun onPasswordChange(v: String) {
        _state.value = _state.value.copy(password = v, errorPassword = null)
    }

    fun onConfirmPasswordChange(v: String) {
        _state.value = _state.value.copy(confirmPassword = v, errorConfirmPassword = null)
    }

    fun onRoleChange(v: String) {
        _state.value = _state.value.copy(role = v)
    }

    fun onTermsToggle(v: Boolean) {
        _state.value = _state.value.copy(termsAccepted = v)
    }

    fun onPasswordVisibilityToggle() {
        _state.value = _state.value.copy(passwordVisible = !_state.value.passwordVisible)
    }

    fun onConfirmPasswordVisibilityToggle() {
        _state.value = _state.value.copy(confirmPasswordVisible = !_state.value.confirmPasswordVisible)
    }

    fun register(onSuccess: () -> Unit) {
        if (!validate()) return

        viewModelScope.launch {
            try {
                _state.value = _state.value.copy(loading = true)
                val result = repository.register(
                    email = _state.value.email,
                    password = _state.value.password,
                    username = _state.value.username,
                    role = _state.value.role
                )

                session.loginUser(
                    result.name,
                    result.uid,
                    result.role ?: "Estudiante"
                )

                _state.value = _state.value.copy(loading = false, registerSuccess = true)
                onSuccess()
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    loading = false,
                    errorGeneral = e.message ?: "Fallo en el registro"
                )
                viewModelScope.launch {
                    delay(3000)
                    _state.value = _state.value.copy(errorGeneral = null)
                }
            }
        }
    }

    private fun validate(): Boolean {
        val current = _state.value

        // 1. Email check
        if (current.email.isBlank()) {
            _state.value = _state.value.copy(errorEmail = "Escribe un correo")
            startErrorTimer()
            return false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(current.email).matches()) {
            _state.value = _state.value.copy(errorEmail = "Correo inválido")
            startErrorTimer()
            return false
        }

        // 2. Username check
        if (current.username.isBlank()) {
            _state.value = _state.value.copy(errorUsername = "Escribe un nombre")
            startErrorTimer()
            return false
        } else if (current.username.length < 6) {
            _state.value = _state.value.copy(errorUsername = "El nombre debe ser mayor a 6 caracteres")
            startErrorTimer()
            return false
        }

        // 3. Password check
        if (current.password.isBlank()) {
            _state.value = _state.value.copy(errorPassword = "Escribe un password")
            startErrorTimer()
            return false
        } else if (current.password.length < 6) {
            _state.value = _state.value.copy(errorPassword = "Su password debe ser mayor 6 caracteres")
            startErrorTimer()
            return false
        }

        // 4. Confirm Password check
        if (current.confirmPassword != current.password) {
            _state.value = _state.value.copy(errorConfirmPassword = "Password y Confirmación no coinciden")
            startErrorTimer()
            return false
        }

        return true
    }

    private fun startErrorTimer() {
        viewModelScope.launch {
            delay(3000)
            _state.value = _state.value.copy(
                errorEmail = null,
                errorUsername = null,
                errorPassword = null,
                errorConfirmPassword = null
            )
        }
    }

    companion object {
        fun provideFactory(context: Context): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return RegisterController(SessionHandler(context)) as T
            }
        }
    }
}
