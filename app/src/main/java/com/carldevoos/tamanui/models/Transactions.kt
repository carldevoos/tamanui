package com.carldevoos.tamanui.models

import java.util.*

data class Transactions(
    private var id: Long,
    private var debt_id: Long,
    private var date: Date,
    private var amount: Long,
    private var type: String
)