package lv.dsl

import lv.dsl.binarytree.binaryTree
import lv.dsl.binarytree.left
import lv.dsl.binarytree.right

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
