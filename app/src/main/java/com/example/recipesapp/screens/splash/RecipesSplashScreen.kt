package com.example.recipesapp.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.recipesapp.R
import com.example.recipesapp.navigation.RecipesScreens
import com.example.recipesapp.ui.theme.spacing
import kotlinx.coroutines.delay

@Composable
fun RecipesSplashScreen(navController: NavHostController) {
    val scale = remember {
      Animatable(0f)
    }

    LaunchedEffect(key1 = true, block = {
        scale.animateTo(targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                }
            )
        )
        delay(1000L)

        navController.navigate(RecipesScreens.MainScreen.name)
    })

    Image(
        painter = painterResource(id = R.drawable.splash),
        contentDescription = "logo",
        modifier = Modifier
            .size(MaterialTheme.spacing.splashLogoSize)
            .scale(scale.value)
    )
}
