package com.an7one.leetcode.ood.lvl3.lc0449

import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import org.junit.Test
import kotlin.test.assertEquals

internal class SolutionApproach0DFSRecursiveTest {
    private val solution = SolutionApproach0DFSRecursive()

    @Test
    fun deserialize_SampleInput1_ShouldReturnExpected() {
        val root = TreeNode(2)
        val left = TreeNode(1)
        val right = TreeNode(3)
        root.left = left
        root.right = right

        val expected = "2,1,3,"

        assertEquals(expected, solution.serialize(root))
    }
}