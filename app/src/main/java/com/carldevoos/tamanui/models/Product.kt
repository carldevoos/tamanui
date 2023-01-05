package com.carldevoos.tamanui.models

import java.util.*

data class Product(
    private var id: Long?,
    private var name: String,
    private var date: Date?,
    private var enable: Boolean?
)