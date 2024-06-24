package com.senac.navegacaoviagem.Componentes

import Cadastro
import CadastroViagem
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.senac.navegacaoviagem.Login

@Composable
fun Navegacao(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { Login(context = LocalContext.current, navController = navController) }
        composable("cadastro") { Cadastro(navController = navController) }
                composable("about") { AboutPage(navController = navController) }
        composable("cadastroviagem") { CadastroViagem(navController = navController) }
        composable(
            route= "menu/{user}",
            arguments = listOf(navArgument("user"){
                type = NavType.StringType })
        ) { backStackEntry ->
            val user = backStackEntry.arguments?.getString("user")
            NavigationBarS(navController = navController, user = user)
        }
    }
}