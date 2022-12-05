package com.carldevoos.tamanui.models

import java.util.*

data class Debts(
    private var id: Long,
    private var debtor_id: Long,
    private var price: Long,
    private var amount: Long,
    private var date: Date,
    private var end_date: Date,
    private var last_update: Date,
    private var status: String
)