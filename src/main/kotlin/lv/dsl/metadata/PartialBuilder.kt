package lv.dsl.metadata

fun <T> partial(value: T, builder: ObjectInfo.(value: T) -> Unit): ObjectInfo =
    ObjectInfo("").apply {
        builder(value)
    }

fun ObjectInfo.includes(other: () -> ObjectInfo) {
    properties.addAll(other().properties)
}
