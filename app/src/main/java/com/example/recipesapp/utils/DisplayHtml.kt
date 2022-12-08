package com.example.recipesapp.utils

import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import org.jsoup.Jsoup

@Composable
fun DisplayHtml(text: String): String {
    return Jsoup.parse(text).text()
}