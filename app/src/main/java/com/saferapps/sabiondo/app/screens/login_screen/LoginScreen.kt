package com.saferapps.sabiondo.app.screens.login_screen

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saferapps.sabiondo.activity.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.res.painterResource
import com.saferapps.sabiondo.R


@Composable
fun LoginScreen(
    onNavigateToRegister: () -> Unit,
    controller: LoginController = viewModel(
        factory = LoginController.provideFactory(LocalContext.current)
    )
) {

    val state by controller.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        snapshotFlow { state.loginSuccess }
            .collect { success ->
                if (success) {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                    controller.resetLoginSuccess()
                }
            }
    }

    // Google Sign In Launcher
    val googleSignInLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            account.idToken?.let { idToken ->
                controller.onGoogleSignIn(idToken)
            }
        } catch (e: ApiException) {
            // Error handling
        }
    }

    fun startGoogleSignIn() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("619175024507-lliblmqjs2cag9a6us5n472pntncvpor.apps.googleusercontent.com")
            .requestEmail()
            .build()
        val googleSignInClient = GoogleSignIn.getClient(context, gso)
        googleSignInLauncher.launch(googleSignInClient.signInIntent)
    }


    val text = buildAnnotatedString {
        append("¿No tienes cuenta? ")
        withStyle(
            SpanStyle(
                color = Color(0xFF448AFF),
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
        ) {
            addLink(
                LinkAnnotation.Clickable(
                    tag = "register",
                    linkInteractionListener = { onNavigateToRegister() }
                ),
                start = length,
                end = length + "Regístrate".length
            )
            append("Regístrate")
        }
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFE3F2FD), Color(0xFFFFFDE7))
                )
            )
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "Bienvenido",
                        color = Color(0xFF546E7A),
                        fontSize = 16.sp
                    )
                    Text(
                        "Sabiondo",
                        color = Color(0xFF448AFF),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 32.sp
                    )
                    Text(
                        "by SaferApps",
                        color = Color(0xFF90A4AE),
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Cursive
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                // CARD
                Box(Modifier.padding(20.dp)) {
                    Card(
                        shape = RoundedCornerShape(40.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier.shadow(
                            elevation = 20.dp,
                            shape = RoundedCornerShape(40.dp),
                            clip = false,
                            ambientColor = Color(0xFF448AFF).copy(alpha = 0.1f),
                            spotColor = Color(0xFF448AFF).copy(alpha = 0.2f)
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 30.dp, start = 24.dp, end = 24.dp, bottom = 60.dp)
                        ) {
                            Text(
                                "Iniciar Sesión",
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                modifier = Modifier.padding(bottom = 24.dp)
                            )

                            TextField(
                                value = state.email,
                                onValueChange = controller::onEmailChange,
                                placeholder = { Text("Correo electrónico", fontSize = 14.sp) },
                                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null, tint = Color(0xFF448AFF)) },
                                modifier = Modifier.fillMaxWidth()
                                    .border(
                                        width = if (state.errorMailVisible) 2.dp else 0.dp,
                                        color = if (state.errorMailVisible) Color.Red else Color.Transparent,
                                        shape = RoundedCornerShape(16.dp)
                                    ),
                                shape = RoundedCornerShape(16.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color(0xFFF1F5F9),
                                    unfocusedContainerColor = Color(0xFFF1F5F9),
                                    errorContainerColor = Color(0xFFF1F5F9),
                                    disabledContainerColor = Color(0xFFF1F5F9),
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    errorIndicatorColor = Color.Transparent,
                                    focusedTextColor = Color.Black,
                                    unfocusedTextColor = Color.Black,
                                    errorTextColor = Color.Black
                                ),
                                textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                                isError = state.errorMailVisible
                            )
                            Spacer(Modifier.height(16.dp))

                            TextField(
                                value = state.password,
                                onValueChange = controller::onPasswordChange,
                                visualTransformation = if (state.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                                placeholder = { Text("Contraseña", fontSize = 14.sp) },
                                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null, tint = Color(0xFF448AFF)) },
                                modifier = Modifier.fillMaxWidth()
                                    .border(
                                        width = if (state.errorPasswordVisible) 2.dp else 0.dp,
                                        color = if (state.errorPasswordVisible) Color.Red else Color.Transparent,
                                        shape = RoundedCornerShape(16.dp)
                                    ),
                                shape = RoundedCornerShape(16.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color(0xFFF1F5F9),
                                    unfocusedContainerColor = Color(0xFFF1F5F9),
                                    errorContainerColor = Color(0xFFF1F5F9),
                                    disabledContainerColor = Color(0xFFF1F5F9),
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    errorIndicatorColor = Color.Transparent,
                                    focusedTextColor = Color.Black,
                                    unfocusedTextColor = Color.Black,
                                    errorTextColor = Color.Black
                                ),
                                trailingIcon = {
                                    IconButton(onClick = controller::onPasswordVisible) {
                                        Icon(if (state.passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff, null)
                                    }
                                },
                                textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                                isError = state.errorPasswordVisible
                            )

                            if (state.authError) {
                                Text(
                                    state.error ?: "Error de autenticación. Verifique sus credenciales.",
                                    color = Color.Red,
                                    modifier = Modifier.padding(vertical = 8.dp),
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .offset(y = 25.dp)
                            .fillMaxWidth(0.85f)
                            .height(50.dp)
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(Color(0xFF00BFA5), Color(0xFF00B0FF))
                                ),
                                shape = RoundedCornerShape(25.dp)
                            )
                            .shadow(8.dp, RoundedCornerShape(25.dp))
                    ) {
                        Button(
                            onClick = controller::login,
                            enabled = !state.loading,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.White,
                            ),
                            modifier = Modifier.fillMaxSize(),
                            shape = RoundedCornerShape(25.dp)
                        ) {
                            if (state.loading) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(20.dp),
                                    color = Color.White,
                                    strokeWidth = 2.dp
                                )
                            } else {
                                Text("INGRESAR", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                            }
                        }
                    }
                }

                Spacer(Modifier.height(40.dp))
                Text(
                    text = text,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(Modifier.height(30.dp))

                Text(
                    "Tipo de Usuario",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = Color(0xFF546E7A),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    FilterChip(
                        selected = state.role == "Docente",
                        onClick = { controller.onRoleChange("Docente") },
                        label = { Text("Docente", fontSize = 14.sp) }
                    )
                    Spacer(Modifier.width(8.dp))
                    FilterChip(
                        selected = state.role == "Estudiante",
                        onClick = { controller.onRoleChange("Estudiante") },
                        label = { Text("Estudiante", fontSize = 14.sp) }
                    )
                }

                Spacer(Modifier.height(30.dp))
                
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(Modifier.weight(1f).height(1.dp).background(Color.LightGray))
                    Text(
                        "O CONTINÚA CON",
                        modifier = Modifier.padding(horizontal = 16.dp),
                        fontSize = 12.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                    Box(Modifier.weight(1f).height(1.dp).background(Color.LightGray))
                }

                Spacer(Modifier.height(24.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    SocialButton("Google") { startGoogleSignIn() }
                }

                Spacer(Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(buildAnnotatedString {
                        append("Al ingresar aceptas ")
                        addLink(
                            LinkAnnotation.Clickable(
                                tag = "terms",
                                linkInteractionListener = { controller.onTermsClick(context) }
                            ),
                            start = length,
                            end = length + "términos y condiciones".length
                        )
                        addStyle(
                            SpanStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            ),
                            start = length,
                            end = length + "términos y condiciones".length
                        )
                        append("términos y condiciones")
                    }, fontSize = 14.sp, textAlign = TextAlign.Center)
                }
                Spacer(Modifier.height(100.dp))
            }
        }
    }
}

@Composable
fun SocialButton(text: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
            .height(50.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            // Icono de Google
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google_icon),
                    contentDescription = "Google Logo",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(Modifier.width(12.dp))
            Text(
                "Continuar con Google",
                fontWeight = FontWeight.Medium,
                color = Color(0xFF1F1F1F),
                fontSize = 16.sp
            )
        }
    }
}
