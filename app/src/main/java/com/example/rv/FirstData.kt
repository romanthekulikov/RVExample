package com.example.rv

data class FirstData(
    override val viewType: ExampleRVItems = ExampleRVItems.FIRST,
    val text: String = ""
) : ViewData
