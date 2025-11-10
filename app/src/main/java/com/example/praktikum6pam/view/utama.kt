package com.example.praktikum6pam.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import com.example.praktikum6pam.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanUtama(
    onBackBtnClick:()-> Unit
) {
    var isLoading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

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
                .fillMaxSize()
                .padding(top = 94.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Real Madrid",
                color = Color.LightGray,
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold
            )

            val logo = painterResource(id = R.drawable.rma)
            Image(
                painter = logo,
                contentDescription = "rma",
                modifier = Modifier
                    .size(200.dp),
                contentScale = ContentScale.Fit
            )
            Column (modifier = Modifier
                .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Text(text = "Nabil Nasruddin Al Mutawakkil",
                    color = Color.LightGray,
                    fontSize = 20.sp
                )
                Text(text = "20230140002",
                    color = Color.LightGray,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(height =10.dp))
                ElevatedButton(
                    modifier = Modifier
                        .width(240.dp)
                        .padding(bottom = 180.dp),
                    enabled = !isLoading,
                    onClick = {
                        isLoading = true
                        scope.launch {
                            delay(1500)
                            isLoading = false
                            onBackBtnClick()
                        }
                    }
                ){
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(24.dp),
                            strokeWidth = 3.dp,
                            color = Color.White
                        )
                    }
                    else {
                        Text(
                            text = "Login",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}