package com.example.recipesapp.data

class DataOrException<T, Boolean, E> (
    var data: T? = null,
    var loading: kotlin.Boolean? = null,
    var e: E? = null )