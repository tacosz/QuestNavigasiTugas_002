package com.example.praktikum6pam.view

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.praktikum6pam.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
            },
            text = {
                Column (modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Name", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = name, fontWeight = FontWeight.Medium, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Gender", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = gender, fontWeight = FontWeight.Medium, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Number", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = number, fontWeight = FontWeight.Medium, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Position", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = position, fontWeight = FontWeight.Medium, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Origin", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = origin, fontWeight = FontWeight.Medium, fontSize = 16.sp)
                }
            },
            confirmButton = {
                Button(onClick = {
                    showDialog = false
                    clearData()
                },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp))
                    {
                        Text("Ok", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        )
    }
    val image = painterResource(id = R.drawable.bg)
    Surface (modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Form Registration",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.LightGray
            )
            Card (
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .padding(top = 12.dp, start = 24.dp, end = 24.dp, bottom = 80.dp)
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(4))
                    .background(
                        Brush.radialGradient(
                        colors = listOf(
                            Color.White.copy(0.8f),
                            Color.White.copy(0.4f)
                        )))
                    .align(Alignment.CenterHorizontally),

            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, start = 20.dp, end = 20.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column {
                        Text(
                            text = "Full Name",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = txtName,
                            singleLine = true,
                            onValueChange = {txtName = it},
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Column {
                        Text(
                            text = "Gender",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Row {
                            jenis.forEach { item ->
                                Row (modifier = Modifier
                                    .selectable(
                                        selected = txtGender == item,
                                        onClick = {txtGender = item}
                                    ), verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = txtGender == item,
                                        onClick = {txtGender = item},
                                        modifier = Modifier
                                            .width(12.dp)
                                            .height(12.dp)
                                            .padding(start = 8.dp)
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Text(
                                        item,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 16.sp
                                    )
                                    Spacer(modifier = Modifier.width(20.dp))
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Column {
                        Text(
                            text = "Number",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = txtNumber,
                            singleLine = true,
                            onValueChange = {txtNumber = it},
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Column {
                        Text(
                            "Position",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = {expanded = it},
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            TextField(
                                value = txtPosition,
                                onValueChange = {},
                                readOnly = true,
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .border(width = 2.dp,
                                        color = Color.White,
                                        shape = RoundedCornerShape(12.dp))
                                    .menuAnchor(),
                                label = {Text("Chose Position")},
                                trailingIcon = {
                                    IconButton(onClick = {}) {
                                        Icon(
                                            icon,
                                            contentDescription = null
                                        )
                                    }
                                },
                            )
                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = {expanded = false}
                            ) {
                                posisi.forEach { opsi ->
                                    DropdownMenuItem(
                                        text = {Text(opsi)},
                                        onClick = {
                                            txtPosition = opsi
                                            expanded = false
                                        },
                                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Column {
                        Text(
                            text = "Origin",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = txtOrigin,
                            singleLine = true,
                            onValueChange = {txtOrigin = it},
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}