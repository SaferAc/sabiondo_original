package com.saferapps.sabiondo.app.screens.login_screen

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val errorMailVisible: Boolean = false,
    val errorPasswordVisible: Boolean = false,
    val passwordVisible: Boolean = false,
    val error: String? = null,
    val role: String? = null,
    val success: Boolean = false,
    val loginSuccess: Boolean= false,
    val authError: Boolean=false,
)