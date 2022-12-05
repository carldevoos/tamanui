package com.carldevoos.tamanui.models

data class DebtsProducts(
    private var id: Long,
    private var debt_id: Long,
    private var product_id: Long,
    private var price: Long
)