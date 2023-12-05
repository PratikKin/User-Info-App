package com.example.userinfoapp.Navigation

sealed class Screen(val route: String) {
    data object HomeScreen : Screen("home_screen")
    data object LangPage : Screen("lang_page")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}