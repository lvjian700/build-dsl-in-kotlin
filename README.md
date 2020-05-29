# Build DSL in Kotlin

## Sample 1 - Binary Tree

```kotlin
val root =
  binaryTree(1) {
    left(2) {
      left(1)
        right(2)
    }
    right(3) {
      right(10)
    }
  }
```

## Sample 2 - Meta info builder


```kotlin
val request = APIRequest(
    name = "Kotlin",
    score = 100,
    product = Product(
        id = UUID.fromString("f9160353-ffda-4df4-a88b-131d28b8d07f"),
        name = "Lang"
    )
)

meta {
  field(request::name)
  field(request::score)

  obj(request::product) { product ->
    includes { productFieldsFor(product) }
  }
}

fun productFieldsFor(value: Product) =
  partial(value) {
    field(it::id) {
      desc = "Unique identity for a product"
    }
    field(it::name) {
      desc = "Name of product"
    }
  }
```

output:

```json
[
  {
    "fieldName": "name",
    "type": "kotlin.String",
    "sampleValue": "Kotlin",
    "nullable": false,
    "desc": ""
  },
  {
    "fieldName": "score",
    "type": "kotlin.Int",
    "sampleValue": 100,
    "nullable": false,
    "desc": ""
  },
  {
    "fieldName": "product",
    "type": "object",
    "properties": [
      {
        "fieldName": "id",
        "type": "java.util.UUID",
        "sampleValue": "f9160353-ffda-4df4-a88b-131d28b8d07f",
        "nullable": false,
        "desc": "Unique identity for a product"
      },
      {
        "fieldName": "name",
        "type": "kotlin.String?",
        "sampleValue": "Lang",
        "nullable": true,
        "desc": "Name of product"
      }
    ]
  }
]
```
