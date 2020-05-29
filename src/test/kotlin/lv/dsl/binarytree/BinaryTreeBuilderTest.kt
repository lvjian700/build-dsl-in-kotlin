package lv.dsl.binarytree

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BinaryTreeBuilderTest {

    @Test
    fun build_binary_tree() {
        val root = binaryTree(1) {}

        assertEquals(1, root.value)
        assertNull(root.left)
        assertNull(root.right)
    }

    @Test
    fun build_binary_tree_with_leafs() {
        val root = binaryTree(1) {
            left(10)
            right(20)
        }

        assertEquals(10, root.left?.value)
        assertEquals(20, root.right?.value)
    }

    @Test
    fun build_left() {
        val root = TreeNode(1)
        root.left(2) {
            left(3)
        }

        assertNull(root.right)
        assertEquals(2, root.left?.value)
        assertNull(root.left?.right)

        assertEquals(3, root.left?.left?.value)
        assertNull(root.left?.left?.right)
    }

    @Test
    fun build_right() {
        val root = TreeNode(1)
        root.right(2) {
            right(3)
        }

        assertNull(root.left)
        assertEquals(2, root.right?.value)
        assertNull(root.right?.left)

        assertEquals(3, root.right?.right?.value)
        assertNull(root.right?.right?.left)
    }
}