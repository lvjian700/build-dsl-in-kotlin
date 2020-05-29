package lv.dsl.metadata

import kotlin.reflect.KProperty0

data class FieldInfo<T>(
    val fieldName: String,
    val type: String,
    val sampleValue: T,
    var nullable: Boolean,
    var desc: String = ""
): MetaInfo

fun <T> ObjectInfo.field(prop: KProperty0<T>, init: FieldInfo<T>.() -> Unit = {}) {
    properties.add(
        FieldInfo(
            fieldName = prop.name,
            type = prop.returnType.toString(),
            nullable = prop.returnType.isMarkedNullable,
            sampleValue = prop.get()
        ).apply(init)
    )
}