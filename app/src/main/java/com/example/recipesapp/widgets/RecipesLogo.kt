package com.example.recipesapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.recipesapp.R
import com.example.recipesapp.ui.theme.spacing

@Composable
fun RecipesLogo() {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "logo",
        modifier = Modifier.size(MaterialTheme.spacing.logoSize)
    )
}