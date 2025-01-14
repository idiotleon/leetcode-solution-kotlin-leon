package com.idiotleon.leetcode.lvl3.lc0333

import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode
import org.junit.Test
import kotlin.test.assertEquals

class Solution0PostorderRecursive1Test {
    val solution = SolutionApproach0PostorderRecursive()

    @Test
    fun test_Input1_ShouldReturnExpected() {
        // [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
        // to build up the tree
        val root = TreeNode(4)
        val node1 = TreeNode(2)
        val node2 = TreeNode(7)
        root.left = node1
        root.right = node2

        val node3 = TreeNode(2)
        val node4 = TreeNode(3)
        node1.left = node3
        node1.right = node4

        val node5 = TreeNode(5)
        node2.left = node5

        val node6 = TreeNode(2)
        node3.left = node6

        val node7 = TreeNode(1)
        node6.left = node7

        val expected = 2

        assertEquals(expected, solution.largestBSTSubtree(root))
    }
}