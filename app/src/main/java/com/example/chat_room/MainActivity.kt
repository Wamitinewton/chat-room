package com.example.chat_room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chat_room.presentation.username.UserNameScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "username_screen"
            ) {
                composable("username_screen") {
                    UserNameScreen(onNavigate = navController::navigate)
                }

                composable(
                    route = "chat_screen/{username}",
                    arguments = listOf(
                        androidx.navigation.navArgument(name = "username") {
                            type = androidx.navigation.NavType.StringType
                            nullable = true
                        }
                    )
                ) {
                    val username = it.arguments?.getString("username")
                    com.example.chat_room.presentation.chat.ChatScreen(username = username)
                }

            }
        }
    }
}

