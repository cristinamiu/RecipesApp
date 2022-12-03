package com.example.recipesapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipesapp.ui.theme.RecipesAppTheme
import com.example.recipesapp.ui.theme.spacing
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecipesAppTheme {
        App()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkTheme() {
    RecipesAppTheme(useDarkTheme = true) {
        App()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                     RecipesAppBar()
                     }
            ,
            content = {},
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesAppBar() {
    CenterAlignedTopAppBar(title = {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "wesgrd",
            modifier = Modifier.size(MaterialTheme.spacing.logoSize)
        )
    },
        colors = topAppBarColors(
        containerColor = MaterialTheme.colorScheme.surfaceVariant),
    )

}














