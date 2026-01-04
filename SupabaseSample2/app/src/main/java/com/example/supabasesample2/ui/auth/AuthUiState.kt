package com.example.supabasesample2.ui.auth

data class AuthUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val authMessage: String? = null
)
