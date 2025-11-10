package com.example.praktikum6pam.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.praktikum6pam.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

    var expanded by remember { mutableStateOf(false) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Default.KeyboardArrowDown

    fun clearData(){
        txtName = ""
        txtGender = ""
        txtNumber = ""
        txtPosition = ""
        txtOrigin = ""
    }

    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {showDialog = false},
            containerColor = Color.DarkGray,
            icon = { Icon(Icons.Filled.CheckCircle,
                null,
                modifier = Modifier.size(64.dp))},
            title = {
                Column (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Succed", fontWeight = FontWeight.Bold, fontSize = 24.sp, color = Color.White)
                    Text(text = "Data saved successfully", fontSize = 16.sp, color = Color.White)
                }
            }
        )
    }
}