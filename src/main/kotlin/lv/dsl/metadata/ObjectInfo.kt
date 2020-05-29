package lv.dsl.metadata

import kotlin.reflect.KProperty0

interface MetaInfo

data class ObjectInfo(
    val fieldName: String,
    val type: String = "object",
    val properties: MutableList<MetaInfo> = mutableListOf()
): MetaInfo

fun meta(init: ObjectInfo.() -> Unit) =
    ObjectInfo("place holder").apply(init)

fun <T> ObjectInfo.obj(prop: KProperty0<T>, init: ObjectInfo.(value: T) -> Unit) {
    properties.add(
        ObjectInfo(prop.name).apply { init(prop.get()) }
    )
}

