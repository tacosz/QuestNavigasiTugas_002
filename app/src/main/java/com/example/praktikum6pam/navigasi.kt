package com.example.praktikum6pam

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum6pam.view.FormPendaftaran
import com.example.praktikum6pam.view.HalamanUtama
import com.example.praktikum6pam.view.ListPemain

enum class Navigasi {
    Main,
    List,
    Form
}

@Composable
fun App(
    navController: NavHostController = rememberNavController()
){
    Box() {
        NavHost(
            navController = navController,
            startDestination = Navigasi.Main.name,
            modifier = Modifier.fillMaxSize()
        ){
            composable(route = Navigasi.Main.name) {
                HalamanUtama(
                    onBackBtnClick = {navController.navigate(Navigasi.Main.name)}
                )
            }
            composable(route = Navigasi.List.name) {
                ListPemain(
                    onUtama = {cancelAndBackToMain(navController)},
                    onDaftar = {navController.navigate(Navigasi.Form.name)}
                )
            }
            composable(route = Navigasi.Form.name) {
                FormPendaftaran(
                    onList = {backToList(navController)},
                    onSubmit = {},
                )
            }
        }
    }
}

private fun cancelAndBackToMain(
    navController: NavHostController
){
    navController.popBackStack(Navigasi.Main.name, inclusive = false)
}

private fun backToList(
    navController: NavHostController
){
    navController.popBackStack(Navigasi.List.name, inclusive = false)
}