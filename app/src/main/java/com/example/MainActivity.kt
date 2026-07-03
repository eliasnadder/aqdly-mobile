package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.ui.screens.*
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            MainApp()
        }
      }
    }
  }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showBottomNav = currentRoute in listOf("dashboard", "contracts", "assistant", "reports", "profile")

    Scaffold(
        bottomBar = {
            if (showBottomNav) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(
                            color = MaterialTheme.colorScheme.surface.copy(alpha = 0.65f)
                        )
                        .border(
                            width = 1.dp,
                            color = Color.White.copy(alpha = 0.3f),
                            shape = RoundedCornerShape(24.dp)
                        )
                ) {
                    NavigationBar(
                        containerColor = Color.Transparent,
                        tonalElevation = 0.dp,
                        windowInsets = WindowInsets(0, 0, 0, 0)
                    ) {
                        NavigationBarItem(
                            selected = currentRoute == "dashboard",
                        onClick = {
                            navController.navigate("dashboard") {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(if (currentRoute == "dashboard") Icons.Filled.Home else Icons.Outlined.Home, contentDescription = "الرئيسية") },
                        label = { Text("الرئيسية") }
                    )
                    NavigationBarItem(
                        selected = currentRoute == "contracts",
                        onClick = {
                            navController.navigate("contracts") {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(if (currentRoute == "contracts") Icons.Filled.Description else Icons.Outlined.Description, contentDescription = "العقود") },
                        label = { Text("العقود") }
                    )
                    NavigationBarItem(
                        selected = currentRoute == "assistant",
                        onClick = {
                            navController.navigate("assistant") {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(if (currentRoute == "assistant") Icons.Filled.SmartToy else Icons.Outlined.SmartToy, contentDescription = "المساعد") },
                        label = { Text("المساعد") }
                    )
                    NavigationBarItem(
                        selected = currentRoute == "reports",
                        onClick = {
                            navController.navigate("reports") {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(if (currentRoute == "reports") Icons.Filled.Analytics else Icons.Outlined.Analytics, contentDescription = "التقارير") },
                        label = { Text("التقارير") }
                    )
                    NavigationBarItem(
                        selected = currentRoute == "profile",
                        onClick = {
                            navController.navigate("profile") {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(if (currentRoute == "profile") Icons.Filled.Person else Icons.Outlined.Person, contentDescription = "الملف") },
                        label = { Text("الملف") }
                    )
                }
                } // Close Box
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "onboarding",
            modifier = Modifier.padding(top = innerPadding.calculateTopPadding())
        ) {
            composable("onboarding") {
                OnboardingScreen(onNavigateToLogin = { navController.navigate("login") { popUpTo("onboarding") { inclusive = true } } })
            }
            composable("login") {
                LoginScreen(onNavigateToDashboard = { navController.navigate("dashboard") { popUpTo("login") { inclusive = true } } })
            }
            composable("dashboard") {
                DashboardScreen(
                    onNavigateToChat = { navController.navigate("chat") },
                    onNavigateToUpload = { navController.navigate("upload") }
                )
            }
            composable("upload") {
                UploadScreen(
                    onNavigateBack = { navController.navigateUp() },
                    onNavigateToAnalysis = { navController.navigate("analysis_flow") }
                )
            }
            composable("contracts") {
                SearchScreen(onNavigateBack = { navController.navigateUp() })
            }
            composable("assistant") {
                ChatScreen(
                    onNavigateBack = { navController.navigateUp() },
                    onNavigateToExport = { navController.navigate("reports") }
                )
            }
            composable("reports") {
                ExportScreen(onNavigateBack = { navController.navigateUp() })
            }
            composable("profile") {
                ProfileScreen(onLogout = { navController.navigate("login") { popUpTo("dashboard") { inclusive = true } } })
            }
            composable("chat") {
                ChatScreen(
                    onNavigateBack = { navController.navigateUp() },
                    onNavigateToExport = { navController.navigate("reports") }
                )
            }
            composable("analysis_flow") {
                AnalysisFlowScreen(
                    onCancel = { navController.navigateUp() },
                    onFinish = {
                        navController.navigate("chat") {
                            popUpTo("upload") { inclusive = true }
                        }
                    }
                )
            }
            composable("compare") {
                CompareScreen(onNavigateBack = { navController.navigateUp() })
            }
        }
    }
}
