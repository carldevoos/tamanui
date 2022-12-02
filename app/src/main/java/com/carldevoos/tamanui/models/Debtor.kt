package com.carldevoos.tamanui.models

class Debtor(
    private var id: Long?,
    private var name: String?,
    private var dni: String?,
    private var phone: String?
) {

    constructor() : this(null, null, null, null)

    constructor(id: Long) : this(id, null, null, null) {
        this.id = id
    }
}