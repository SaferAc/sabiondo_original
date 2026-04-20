package com.saferapps.sabiondo.app.screens.register

data class RegisterUiState(
    val email: String = "",
    val username: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val role: String = "Docente",
    val termsAccepted: Boolean = false,
    val loading: Boolean = false,
    val errorEmail: String? = null,
    val errorUsername: String? = null,
    val errorPassword: String? = null,
    val errorConfirmPassword: String? = null,
    val errorGeneral: String? = null,
    val passwordVisible: Boolean = false,
    val confirmPasswordVisible: Boolean = false,
    val registerSuccess: Boolean = false
)
