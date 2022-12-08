package com.example.recipesapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.example.recipesapp.widgets.RecipesLogo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesTopAppBar(
    navController: NavController,
    icon: ImageVector? = null,
    onButtonClicked: () -> Unit = {navController.popBackStack()}) {
    CenterAlignedTopAppBar(
        title = { RecipesLogo() },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant),
        actions = {
                IconButton(onClick = {
                }) {
                    Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "")
                }
        },
        navigationIcon = {
            if(icon != null) {
                Icon(imageVector = icon,
                    contentDescription = "Back Arrow",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.clickable {
                    onButtonClicked.invoke()
                })
            }
        }
    )
}

