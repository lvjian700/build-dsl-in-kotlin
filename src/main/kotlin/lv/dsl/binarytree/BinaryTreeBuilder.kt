package lv.dsl.binarytree

fun <T> binaryTree(value: T, init: TreeNode<T>.() -> Unit)
    = TreeNode<T>(value).apply(init)

fun <T> TreeNode<T>.left(value: T, init: TreeNode<T>.() -> Unit = {}) {
    left = TreeNode<T>(value).apply(init)
}

fun <T> TreeNode<T>.right(value: T, init: TreeNode<T>.() -> Unit = {}) {
    right = TreeNode<T>(value).apply(init)
}