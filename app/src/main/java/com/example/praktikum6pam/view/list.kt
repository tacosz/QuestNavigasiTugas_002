package com.example.praktikum6pam.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.praktikum6pam.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPemain(
    onUtama: () -> Unit,
    onDaftar: () -> Unit,
    modifier: Modifier = Modifier
){
    val allBiodata = listOf(
        listOf(
            "NAMA LENGKAP" to "Xabi Alonso",
            "NUMBER" to "-",
            "POSISI" to "Head Coach",
            "ASAL" to "Spain"
        ),
        listOf(
            "NAMA LENGKAP" to "Courtois",
            "NUMBER" to "1",
            "POSISI" to "Goalkeeper",
            "ASAL" to "Belgium"
        ),
        listOf(
            "NAMA LENGKAP" to "E. Militao",
            "NUMBER" to "3",
            "POSISI" to "Defender",
            "ASAL" to "Brazil"
        ),
        listOf(
            "NAMA LENGKAP" to "A. Carreras",
            "NUMBER" to "18",
            "POSISI" to "Defender",
            "ASAL" to "Spain"
        ),
        listOf(
            "NAMA LENGKAP" to "Huijsen",
            "NUMBER" to "24",
            "POSISI" to "Defender",
            "ASAL" to "Spain"
        ),
        listOf(
            "NAMA LENGKAP" to "Bellingham",
            "NUMBER" to "5",
            "POSISI" to "Midfielder",
            "ASAL" to "England"
        ),
        listOf(
            "NAMA LENGKAP" to "Camavinga",
            "NUMBER" to "6",
            "POSISI" to "Midfielder",
            "ASAL" to "France"
        ),
        listOf(
            "NAMA LENGKAP" to "Valverde",
            "NUMBER" to "8",
            "POSISI" to "Midfielder",
            "ASAL" to "Uruguay"
        ),
        listOf(
            "NAMA LENGKAP" to "Tchouameni",
            "NUMBER" to "14",
            "POSISI" to "Midfielder",
            "ASAL" to "France"
        ),
        listOf(
            "NAMA LENGKAP" to "Arda Guler",
            "NUMBER" to "15",
            "POSISI" to "Midfielder",
            "ASAL" to "Belgium"
        ),
        listOf(
            "NAMA LENGKAP" to "Vini Jr.",
            "NUMBER" to "7",
            "POSISI" to "Forward",
            "ASAL" to "Brazil"
        ),
        listOf(
            "NAMA LENGKAP" to "Mbappe",
            "NUMBER" to "10",
            "POSISI" to "Forward",
            "ASAL" to "France"
        ),

    )
}