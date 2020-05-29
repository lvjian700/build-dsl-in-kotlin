package lv.dsl.metadata.app

import java.util.*

data class APIRequest(
    val name: String,
    val score: Int,
    val product: Product
)

data class Product(
    val id: UUID,
    val name: String?
)
