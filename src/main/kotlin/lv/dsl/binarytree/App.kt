package lv.dsl.binarytree

fun main() {
    val root = binaryTree(1) {
        left(2) {
            left(1)
            right(2)
        }
        right(3) {
            right(10)
        }
    }

    println(root)
}
