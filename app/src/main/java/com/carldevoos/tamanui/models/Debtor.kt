package com.carldevoos.tamanui.models

data class Debtor(
    private var id: Long?,
    private var name: String,
    private var dni: String?,
    private var phone: String?
) {
    constructor(name: String) : this(
        id = null,
        name = name,
        dni = null,
        phone = null
    )
}