package com.luitech.springbootexamples.domain

class TacoOrder {
    private val deliveryName: String? = null
    private val deliveryStreet: String? = null
    private val deliveryCity: String? = null
    private val deliveryState: String? = null
    private val deliveryZip: String? = null
    private val ccNumber: String? = null
    private val ccExpiration: String? = null
    private val ccCVV: String? = null

    private val tacos: MutableList<Taco> = ArrayList()

    fun addTaco(taco: Taco) {
        tacos.add(taco)
    }
}
