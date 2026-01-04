package com.example.supabasesample2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.supabasesample2.data.AuthRepository
import com.example.supabasesample2.ui.auth.AuthViewModelFactory
import com.example.supabasesample2.ui.auth.RegisterScreen
import com.example.supabasesample2.ui.theme.SupabaseSample2Theme

class ComposeActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val authRepository = AuthRepository()
        val viewModelFactory = AuthViewModelFactory(authRepository)

        setContent {
            SupabaseSample2Theme {
                RegisterScreen(viewModel = viewModel(factory = viewModelFactory))
            }
        }
    }
}
