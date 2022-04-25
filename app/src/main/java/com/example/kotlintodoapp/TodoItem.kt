package com.example.kotlintodoapp

data class TodoItem (
    val title:String,
    var isChecked : Boolean = false
    )