package com.example.recipesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipesapp.ui.theme.RecipesAppTheme
import com.example.recipesapp.ui.theme.spacing

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

@Composable
fun Greeting(name: String, style: TextStyle) {
    Text(text = "Hello $name!",
    style = style)
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

@Composable
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column() {
            Greeting(name = "Chef",
                style = MaterialTheme.typography.displayLarge)

            Greeting(name = "Chef",
                style = MaterialTheme.typography.displayMedium)

            Greeting(name = "Chef",
                style = MaterialTheme.typography.bodyLarge)

        Card(colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)) {
            Greeting(name = "Card", style = MaterialTheme.typography.displaySmall)
        }
            Card(colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)) {
                Greeting(name = "Card", style = MaterialTheme.typography.displaySmall)
            }
            Card(colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiaryContainer)) {
                Greeting(name = "Card", style = MaterialTheme.typography.displaySmall)
            }
            Card(modifier = Modifier.padding(top = MaterialTheme.spacing.extraLarge),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceVariant)) {
                Greeting(name = "Card", style = MaterialTheme.typography.displaySmall)
            }
        }




    }
}