package com.example.praktikum6pam.view

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum6pam.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

fun Modifier.listLoading(
    isLoading: Boolean,
    durationMillis: Int = 1000,
): Modifier = composed {
    if (!isLoading) {
        return@composed this
    }
    val transition = rememberInfiniteTransition(label = "")

    val translateAnimation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 50f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = durationMillis,
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Restart
        ),
    )

    return@composed this
        .clip(RoundedCornerShape(24.dp))
        .drawBehind {
            drawRect(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.LightGray.copy(alpha = 0.2f),
                        Color.LightGray.copy(alpha = 1.0f),
                        Color.LightGray.copy(alpha = 0.2f),
                    ),
                    start = Offset(x = translateAnimation, y = translateAnimation),
                    end = Offset(x = translateAnimation + 100f, y = translateAnimation + 100f)
                )
            )
        }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPemain(
    onUtama: () -> Unit,
    onDaftar: () -> Unit,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = R.drawable.bg)
    val allBiodata = listOf(
        listOf(
            "Name" to "Xabi Alonso",
            "Number" to "-",
            "Position" to "Head Coach",
            "Origin" to "Spain"
        ),
        listOf(
            "Name" to "Courtois",
            "Number" to "1",
            "Position" to "Goalkeeper",
            "Origin" to "Belgium"
        ),
        listOf(
            "Name" to "E. Militao",
            "Number" to "3",
            "Position" to "Defender",
            "Origin" to "Brazil"
        ),
        listOf(
            "Name" to "A. Carreras",
            "Number" to "18",
            "Position" to "Defender",
            "Origin" to "Spain"
        ),
        listOf(
            "Name" to "Huijsen",
            "Number" to "24",
            "Position" to "Defender",
            "Origin" to "Spain"
        ),
        listOf(
            "Name" to "Bellingham",
            "Number" to "5",
            "Position" to "Midfielder",
            "Origin" to "England"
        ),
        listOf(
            "Name" to "Camavinga",
            "Number" to "6",
            "Position" to "Midfielder",
            "Origin" to "France"
        ),
        listOf(
            "Name" to "Valverde",
            "Number" to "8",
            "Position" to "Midfielder",
            "Origin" to "Uruguay"
        ),
        listOf(
            "Name" to "Tchouameni",
            "Number" to "14",
            "Position" to "Midfielder",
            "Origin" to "France"
        ),
        listOf(
            "Name" to "Arda Guler",
            "Number" to "15",
            "Position" to "Midfielder",
            "Origin" to "Belgium"
        ),
        listOf(
            "Name" to "Vini Jr.",
            "Number" to "7",
            "Position" to "Forward",
            "Origin" to "Brazil"
        ),
        listOf(
            "Name" to "Mbappe",
            "Number" to "10",
            "Position" to "Forward",
            "Origin" to "France"
        ),
    )
    var isLoading by remember { mutableStateOf(true) }
    LaunchedEffect(key1 = true) {
        delay(2000)
        isLoading = false
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp, start = 10.dp, end = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Player Data List",
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 92.dp, top = 16.dp)
            ) {
                if (isLoading) {
                    items(7) {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .listLoading(isLoading = true)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                } else {
                    itemsIndexed(allBiodata) { index, biodata ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(color = Color.LightGray)
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
                                                    color = Color.Gray
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
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(vertical = 12.dp)
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier
                    .width(160.dp),
                onClick = onUtama,
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                border = BorderStroke(1.dp, Color.LightGray)
            ) {
                Text("Main")
            }
            Button(
                modifier = Modifier
                    .width(160.dp),
                onClick = onDaftar,
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                border = BorderStroke(1.dp, Color.LightGray)
            ) {
                Text(text = "Form")
            }
        }
    }
}