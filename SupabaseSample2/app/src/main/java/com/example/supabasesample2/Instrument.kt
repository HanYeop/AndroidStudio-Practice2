package com.example.supabasesample2

import kotlinx.serialization.Serializable

@Serializable
data class Instrument(
    val id: Int,
    val name: String,
)