package com.saferapps.sabiondo.app.screens.login_screen

import android.content.Intent
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.saferapps.sabiondo.activity.MainActivity


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


    val text = buildAnnotatedString {
        append("¿No tienes cuenta? ")
        addLink(
            LinkAnnotation.Clickable(
                tag = "register",
                linkInteractionListener = { onNavigateToRegister() }
            ),
            start = length,
            end = length + "Regístrate".length
        )
        addStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.Underline
            ),
            start = length,
            end = length + "Regístrate".length
        )
        append("Regístrate")
    }

    Box(Modifier.fillMaxSize()) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .shadow(5.dp)
                    .background(Color(0xFF448AFF))
                    .padding(start = 30.dp, top = 40.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Column {
                    Text(
                        "Bienvenido",
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 17.sp
                    )
                    Text(
                        "Iniciar Sesión",
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
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
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White.copy(alpha = 0.5f)
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 60.dp)
                        ) {
                            OutlinedTextField(
                                value = state.email,
                                label = { Text("Correo", ) },
                                textStyle = TextStyle(color = Color.Black),
                                onValueChange = controller::onEmailChange,
                                placeholder = { Text("Ingrese su correo") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp),
                                isError = state.errorMailVisible,
                                supportingText = {
                                    if (state.errorMailVisible) {
                                        Text("Ingresa un correo válido", style = TextStyle(color = Color.Red))
                                    }
                                }
                            )

                            Spacer(Modifier.height(16.dp))

                            OutlinedTextField(
                                value = state.password,
                                label = { Text("Contraseña") },
                                textStyle = TextStyle(color = Color.Black),
                                onValueChange = controller::onPasswordChange,
                                visualTransformation = if (state.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                                placeholder = { Text("Ingresa contraseña") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp),
                                isError = state.errorPasswordVisible,
                                trailingIcon = {
                                    IconButton(onClick = controller::onPasswordVisible) {
                                        Icon(if (state.passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff, null)
                                    }
                                },
                                supportingText = {
                                    if (state.errorPasswordVisible) {
                                        Text("Contraseña Incorrecta", style = TextStyle(color = Color.Red))
                                    }
                                }
                            )

                            if (state.authError) {
                                Text(
                                    "Error de autenticación. Verifique sus credenciales.",
                                    color = Color.Red,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }

                    Button(
                        onClick = controller::login,
                        enabled = !state.loading,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2979FF),
                            contentColor = Color.White,
                        ),
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .offset(y = 20.dp)
                            .fillMaxWidth(0.9f)
                    ) {
                        if (state.loading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                color = Color.Blue,
                                strokeWidth = 2.dp
                            )
                        } else {
                            Text("Ingresar")
                        }
                    }
                }

                Spacer(Modifier.height(30.dp))
                Text(
                    text = text,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(Modifier.height(16.dp))
                Text(
                    "Ingresar con PlayGames:",
                    modifier = Modifier.padding(start = 16.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2979FF)
                )

                Spacer(Modifier.height(8.dp))
                Text(
                    "Tipo de Usuario",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = Color(0xFF448AFF)
                )

                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    FilterChip(
                        selected = state.role == "Docente",
                        onClick = { controller.onRoleChange("Docente") },
                        label = { Text("Docente") }
                    )
                    Spacer(Modifier.width(8.dp))
                    FilterChip(
                        selected = state.role == "Estudiante",
                        onClick = { controller.onRoleChange("Estudiante") },
                        label = { Text("Estudiante") }
                    )
                }

                Spacer(Modifier.height(16.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)
                ) {
                    Text("Play Games")
                }

                Spacer(Modifier.height(16.dp))
                Text(
                    "También puedes:",
                    modifier = Modifier.padding(start = 16.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2979FF)
                )

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Black,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 60.dp, vertical = 16.dp)
                ) {
                    Text("Continuar como invitado")
                }

                Row(
                    modifier = Modifier.padding(horizontal = 16.dp),
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
                                fontWeight = FontWeight.Bold
                            ),
                            start = length,
                            end = length + "términos y condiciones".length
                        )
                        append("términos y condiciones")
                    })
                }
                Spacer(Modifier.height(100.dp))
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text("Sabiondo", color = Color(0xFF448AFF), fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Text("by SaferApps", fontSize = 24.sp, fontFamily = FontFamily.Cursive)
        }
    }
}
