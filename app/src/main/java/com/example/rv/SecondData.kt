package com.example.rv

data class SecondData(
    override val viewType: ExampleRVItems = ExampleRVItems.SECOND,
    val switched: Boolean = false,
    val text: String
) : ViewData
