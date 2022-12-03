package com.example.recipesapp.components

import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipesapp.widgets.RecipesLogo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesTopAppBar(isMainScreen: Boolean = false) {
    CenterAlignedTopAppBar(
        title = { RecipesLogo() },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant),
        actions = {
            if (isMainScreen) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "")
                }
            }
        }
    )
}

