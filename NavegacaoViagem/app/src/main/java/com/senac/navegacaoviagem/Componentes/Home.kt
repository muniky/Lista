package com.senac.navegacaoviagem.Componentes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.ui.Modifier

@Composable
fun Home(navController: NavController, user: String?){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text("Seja bem-vinda $user!")
    }
}