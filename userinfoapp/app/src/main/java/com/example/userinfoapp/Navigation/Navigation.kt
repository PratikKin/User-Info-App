package com.example.userinfoapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.infoapp.components.HomePage
import com.example.userinfoapp.components.LangPage

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomePage(navController)
        }
        composable(
            route = Screen.LangPage.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Subject"
                }
            )) { entry ->
            entry.arguments?.getString("name")?.let { LangPage(navController, name = it) }
        }
}}
