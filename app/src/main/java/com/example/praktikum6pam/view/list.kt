package com.example.praktikum6pam.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Player Data List")

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                itemsIndexed(allBiodata) { index, biodata ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(color = Color.DarkGray)
                            .padding(20.dp)
                    ) {
                        biodata.chunked(2).forEach { rowItems ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                rowItems.forEach { (label, value) ->
                                    Column(
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Text(
                                            text = label,
                                            style = MaterialTheme.typography.labelMedium.copy(
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                        )
                                        Text(
                                            text = value,
                                            style = MaterialTheme.typography.bodyMedium.copy(
                                                color = Color.Black
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = onUtama,
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                border = BorderStroke(1.dp, Color.LightGray)
            ) {
                Text("Main", color = Color.Black)
            }
            Button(
                onClick = onDaftar,
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                border = BorderStroke(1.dp, Color.LightGray)
            ) {
                Text(text = "Form")
            }
        }
    }
}