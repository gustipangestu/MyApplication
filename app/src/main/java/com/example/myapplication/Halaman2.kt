package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Hal2(navigation: NavController, inputNama: String?){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Button(onClick = {
            navigation.navigate(Routes.HALAMAN_1)
        }) {
            Text(text = "Ke Hal 1")
        }
        Text(text = inputNama.toString())
    }
}

