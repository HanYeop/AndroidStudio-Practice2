package com.example.supabasesample2.ui.auth

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.supabasesample2.data.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository): ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun clearAuthMessage() {
        _uiState.update { it.copy(authMessage = null) }
    }

    fun signUpWithEmail() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, authMessage = null) }
            try {
                repository.signUpWithEmail(_uiState.value.email, _uiState.value.password)
                _uiState.update { it.copy(isLoading = false, authMessage = "Sign up successful! Please check your email.") }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, authMessage = "Error: ${e.localizedMessage}") }
            }
        }
    }

    fun loginGoogleUser(context: Context) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, authMessage = null) }
            try {
                repository.loginGoogleUser(context)
                _uiState.update { it.copy(isLoading = false, authMessage = "Google sign in successful!") }
            } catch (e: Exception) {
                Log.e("google", e.localizedMessage ?: "Unknown error")
                _uiState.update { it.copy(isLoading = false, authMessage = "Error: ${e.localizedMessage}") }
            }
        }
    }
}

class AuthViewModelFactory(private val repository: AuthRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AuthViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
