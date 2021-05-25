package me.rerere.polymartapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.primarySurface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import me.rerere.polymartapp.ui.route.IndexPage
import me.rerere.polymartapp.ui.route.SplashPage
import me.rerere.polymartapp.ui.theme.PolymartAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            PolymartAppTheme {
                val systemUiController = rememberSystemUiController()
                val primaryColor = MaterialTheme.colors.primarySurface

                // set ui color
                SideEffect {
                    systemUiController.setNavigationBarColor(primaryColor)
                    systemUiController.setStatusBarColor(primaryColor, false)
                }

                ProvideWindowInsets {
                    val navController = rememberNavController()

                    // navigation
                    NavHost(modifier = Modifier.fillMaxSize(), navController = navController, startDestination = "splash") {
                        composable("splash") {
                            SplashPage(navController)
                        }

                        composable("index") {
                            IndexPage(navController)
                        }

                        composable("search"){

                        }
                    }
                }
            }
        }
    }
}