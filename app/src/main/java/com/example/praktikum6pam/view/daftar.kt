package com.example.praktikum6pam.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.praktikum6pam.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPendaftaran(
    onList: () -> Unit,
    onSubmit: () -> Unit
) {
    var txtName by remember { mutableStateOf("") }
    var txtGender by remember { mutableStateOf("") }
    var txtNumber by remember { mutableStateOf("") }
    var txtPosition by remember { mutableStateOf("") }
    var txtOrigin by remember { mutableStateOf("") }

    var name by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var position by remember { mutableStateOf("") }
    var origin by remember { mutableStateOf("") }

    val jenis: List<String> = listOf("Man", "Woman")
    val posisi: List<String> = listOf("Goalkeeper", "Defender", "Midfielder", "Forward", "Coaching Staff")


}