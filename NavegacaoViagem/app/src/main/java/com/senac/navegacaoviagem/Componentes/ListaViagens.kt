package com.senac.navegacaoviagem.Componentes

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.senac.navegacaoviagem.Model.TipoViagem
import com.senac.navegacaoviagem.Model.Viagem
import java.util.Date

@Composable
fun TelaViagem(navController: NavController) {
    val listaviagens = listOf(
        Viagem("Maldivas", TipoViagem.LAZER, Date(), Date(), 100.000 ),
        Viagem("Turquia", TipoViagem.NEGOCIOS, Date(), Date(), 80.000),
        Viagem("índia", TipoViagem.NEGOCIOS, Date(), Date(), 75.000),
        Viagem("Las Vegas", TipoViagem.NEGOCIOS, Date(), Date(), 200.300),
        Viagem("Alemanha", TipoViagem.LAZER, Date(), Date(), 50.000),
        Viagem("Portugal", TipoViagem.NEGOCIOS, Date(), Date(), 150.250)
    )
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(route = "cadastroviagem") },
                containerColor = Color.Magenta,
                contentColor = Color(0xFFE91E63)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar Viagem")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(
                text = "Minhas Viagens",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(listaviagens) { trip ->
                    TripCard(trip, navController)
                }
            }
        }
    }
}




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TripCard(trip: Viagem, navController: NavController) {
    val ctx = LocalContext.current
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = {
                    Toast
                        .makeText(ctx, "Destino: ${trip.destino}", Toast.LENGTH_SHORT)
                        .show()
                },
                onLongClick = {
                    navController.navigate("cadastroviagem")
                }
            )
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            Text(text = trip.destino, style = MaterialTheme.typography.titleLarge)
            Text(text = "Tipo: ${trip.tipo}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Data de Início: ${trip.DataInicial}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Data Final: ${trip.DataFinal}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Valor: R$ ${trip.Valor}", style = MaterialTheme.typography.bodySmall)
        }
    }
}