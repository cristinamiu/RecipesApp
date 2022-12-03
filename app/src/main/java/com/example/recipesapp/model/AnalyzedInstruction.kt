package com.example.recipesapp.model

data class AnalyzedInstruction(
    val name: String,
    val steps: List<Step>
)