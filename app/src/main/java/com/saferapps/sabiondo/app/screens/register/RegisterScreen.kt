package com.saferapps.sabiondo.app.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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

@Composable
fun RegisterScreen(
    onNavigateToLogin: () -> Unit = {},
    onRegisterSuccess: () -> Unit = {},
    controller: RegisterController = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = RegisterController.provideFactory(androidx.compose.ui.platform.LocalContext.current)
    )
) {
    val state by controller.state.collectAsState()
    val scrollState = rememberScrollState()
    val context = androidx.compose.ui.platform.LocalContext.current

    LaunchedEffect(state.registerSuccess) {
        if (state.registerSuccess) {
            val intent = android.content.Intent(context, com.saferapps.sabiondo.activity.MainActivity::class.java)
            context.startActivity(intent)
            onRegisterSuccess()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFE3F2FD), Color(0xFFFFF9C4))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            // HEADER
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, start = 24.dp, end = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Sabiondo", color = Color(0xFF448AFF), fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
                    Text("by SaferApps", fontSize = 16.sp, fontFamily = FontFamily.Cursive)
                }

                Text(
                    "Inicia sesión",
                    color = Color(0xFF448AFF),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.clickable { onNavigateToLogin() }
                )
            }

            

            // CARD
            Box(Modifier.padding(20.dp)) {
                Card(
                    shape = RoundedCornerShape(40.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
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
                            "Crear Cuenta",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(bottom = 24.dp)
                        )

                        Text("Nombre de usuario", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                        Spacer(Modifier.height(8.dp))

                        TextField(
                            value = state.username,
                            onValueChange = controller::onUsernameChange,
                            leadingIcon = { Icon(Icons.Default.Person, null, tint = Color(0xFF448AFF)) },
                            modifier = Modifier.fillMaxWidth()
                                .border(
                                    width = if (state.errorUsername != null) 2.dp else 0.dp,
                                    color = if (state.errorUsername != null) Color.Red else Color.Transparent,
                                    shape = RoundedCornerShape(16.dp)
                                ),
                            shape = RoundedCornerShape(16.dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFFF1F5F9),
                                unfocusedContainerColor = Color(0xFFF1F5F9),
                                errorContainerColor = Color(0xFFF1F5F9),
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                errorIndicatorColor = Color.Transparent,
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                errorTextColor = Color.Black
                            ),
                            textStyle = TextStyle(color = Color.Black),
                            isError = state.errorUsername != null
                        )
                        if (state.errorUsername != null) {
                            Text(state.errorUsername!!, color = Color.Red, fontSize = 12.sp)
                        }
                        
                        Spacer(Modifier.height(16.dp))

                        Text("Correo electrónico", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                        Spacer(Modifier.height(8.dp))
                        TextField(
                            value = state.email,
                            onValueChange = controller::onEmailChange,
                            leadingIcon = { Icon(Icons.Default.AlternateEmail, null, tint = Color(0xFF448AFF)) },
                            modifier = Modifier.fillMaxWidth()
                                .border(
                                    width = if (state.errorEmail != null) 2.dp else 0.dp,
                                    color = if (state.errorEmail != null) Color.Red else Color.Transparent,
                                    shape = RoundedCornerShape(16.dp)
                                ),
                            shape = RoundedCornerShape(16.dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFFF1F5F9),
                                unfocusedContainerColor = Color(0xFFF1F5F9),
                                errorContainerColor = Color(0xFFF1F5F9),
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                errorIndicatorColor = Color.Transparent,
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                errorTextColor = Color.Black
                            ),
                            textStyle = TextStyle(color = Color.Black),
                            isError = state.errorEmail != null
                        )
                        if (state.errorEmail != null) {
                            Text(state.errorEmail!!, color = Color.Red, fontSize = 12.sp)
                        }

                        Spacer(Modifier.height(16.dp))

                        Text("Contraseña", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                        Spacer(Modifier.height(8.dp))
                        TextField(
                            value = state.password,
                            onValueChange = controller::onPasswordChange,
                            visualTransformation = if (state.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            leadingIcon = { Icon(Icons.Default.Lock, null, tint = Color(0xFF448AFF)) },
                            trailingIcon = {
                                IconButton(onClick = controller::onPasswordVisibilityToggle) {
                                    Icon(if (state.passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff, null)
                                }
                            },
                            modifier = Modifier.fillMaxWidth()
                                .border(
                                    width = if (state.errorPassword != null) 2.dp else 0.dp,
                                    color = if (state.errorPassword != null) Color.Red else Color.Transparent,
                                    shape = RoundedCornerShape(16.dp)
                                ),
                            shape = RoundedCornerShape(16.dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFFF1F5F9),
                                unfocusedContainerColor = Color(0xFFF1F5F9),
                                errorContainerColor = Color(0xFFF1F5F9),
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                errorIndicatorColor = Color.Transparent,
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                errorTextColor = Color.Black
                            ),
                            textStyle = TextStyle(color = Color.Black),
                            isError = state.errorPassword != null
                        )
                        if (state.errorPassword != null) {
                            Text(state.errorPassword!!, color = Color.Red, fontSize = 12.sp)
                        }

                        Spacer(Modifier.height(16.dp))

                        Text("Confirmar Contraseña", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                        Spacer(Modifier.height(8.dp))
                        TextField(
                            value = state.confirmPassword,
                            onValueChange = controller::onConfirmPasswordChange,
                            visualTransformation = if (state.confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            leadingIcon = { Icon(Icons.Default.Shield, null, tint = Color(0xFF448AFF)) },
                            trailingIcon = {
                                IconButton(onClick = controller::onConfirmPasswordVisibilityToggle) {
                                    Icon(if (state.confirmPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff, null)
                                }
                            },
                            modifier = Modifier.fillMaxWidth()
                                .border(
                                    width = if (state.errorConfirmPassword != null) 2.dp else 0.dp,
                                    color = if (state.errorConfirmPassword != null) Color.Red else Color.Transparent,
                                    shape = RoundedCornerShape(16.dp)
                                ),
                            shape = RoundedCornerShape(16.dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFFF1F5F9),
                                unfocusedContainerColor = Color(0xFFF1F5F9),
                                errorContainerColor = Color(0xFFF1F5F9),
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                errorIndicatorColor = Color.Transparent,
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                errorTextColor = Color.Black
                            ),
                            textStyle = TextStyle(color = Color.Black),
                            isError = state.errorConfirmPassword != null
                        )
                        if (state.errorConfirmPassword != null) {
                            Text(state.errorConfirmPassword!!, color = Color.Red, fontSize = 12.sp)
                        }

                        Spacer(Modifier.height(24.dp))

                        Text(
                            "Elige tu rol",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF448AFF),
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        
                        Spacer(Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            RoleButton("Estudiante", state.role == "Estudiante", Icons.Default.School) { controller.onRoleChange("Estudiante") }
                            RoleButton("Docente", state.role == "Docente", Icons.Default.Person) { controller.onRoleChange("Docente") }
                        }

                        if (state.errorGeneral != null) {
                            Spacer(Modifier.height(16.dp))
                            Text(state.errorGeneral!!, color = Color.Red, fontSize = 14.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
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
                        onClick = { controller.register(onRegisterSuccess) },
                        enabled = !state.loading,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.White,
                        ),
                        modifier = Modifier.fillMaxSize(),
                        shape = RoundedCornerShape(25.dp)
                    ) {
                        if (state.loading) {
                            androidx.compose.material3.CircularProgressIndicator(color = Color.White, modifier = Modifier.size(24.dp))
                        } else {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("REGISTRAR", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                                Spacer(Modifier.width(8.dp))
                                Icon(Icons.Default.ArrowForward, null)
                            }
                        }
                    }
                }
            }

            Spacer(Modifier.height(40.dp))
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(buildAnnotatedString {
                    append("Al registrarte aceptas ")
                    withStyle(
                        SpanStyle(
                            color = Color(0xFF448AFF),
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        addLink(
                            LinkAnnotation.Clickable(
                                tag = "terms",
                                linkInteractionListener = {  }
                            ),
                            start = length,
                            end = length + "términos y condiciones".length
                        )
                        append("términos y condiciones")
                    }
                }, fontSize = 14.sp, textAlign = TextAlign.Center, color = Color.Gray)
            }

            Spacer(Modifier.height(100.dp))
        }


    }
}

@Composable
fun RoleButton(text: String, isSelected: Boolean, icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(110.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(if (isSelected) Color(0xFFE3F2FD) else Color(0xFFF1F5F9))
            .border(
                width = if (isSelected) 2.dp else 0.dp,
                color = if (isSelected) Color(0xFF448AFF) else Color.Transparent,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                icon,
                contentDescription = null,
                tint = if (isSelected) Color(0xFF448AFF) else Color.Gray,
                modifier = Modifier.size(32.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = if (isSelected) Color(0xFF448AFF) else Color.Gray
            )
        }
    }
}