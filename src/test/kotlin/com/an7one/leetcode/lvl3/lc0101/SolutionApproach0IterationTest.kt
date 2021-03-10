package com.an7one.leetcode.lvl3.lc0101

import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import org.junit.Assert.assertFalse
import org.junit.Test

internal class SolutionApproach0IterationTest {
    private val solution = SolutionApproach0DFSIterative()

    @Test
    fun isSymmetric_TestCase147_ShouldReturnExpected() {
        val root = TreeNode(2)
        val left = TreeNode(3)
        val right = TreeNode(3)

        root.left = left
        root.right = right

        left.left = TreeNode(4)
        left.right = TreeNode(5)

        right.right = TreeNode(4)

        assertFalse(solution.isSymmetric(root))
    }
}