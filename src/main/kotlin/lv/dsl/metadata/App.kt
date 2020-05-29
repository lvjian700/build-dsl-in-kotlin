package lv.dsl.metadata

import com.google.gson.GsonBuilder
import lv.dsl.metadata.app.APIRequest
import lv.dsl.metadata.app.Product
import java.util.*


fun main() {
    val meta = meta {
        field(request::name)
        field(request::score)

        obj(request::product) { product ->
            includes { productFieldsFor(product) }
        }
    }

    val gson = GsonBuilder()
        .setPrettyPrinting()
        .create()

    println(gson.toJson(meta.properties))
}


val request = APIRequest(
    name = "Kotlin",
    score = 100,
    product = Product(
        id = UUID.fromString("f9160353-ffda-4df4-a88b-131d28b8d07f"),
        name = "Lang"
    )
)

fun productFieldsFor(value: Product) =
    partial(value) {
        field(it::id) {
            desc = "Unique identity for a product"
        }
        field(it::name) {
            desc = "Name of product"
        }
    }