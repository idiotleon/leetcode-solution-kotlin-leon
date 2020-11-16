package com.zea7ot.byCompany.other.inorderTraverseBinaryTree

import org.junit.Test
import kotlin.test.assertEquals


internal class SolutionApproach0InorderTraversalTest {
    val solution = SolutionApproach0InorderTraversal()

    @Test
    fun findNthInorderTreeNode_SampleInput1_ShouldReturnExpected() {
        val root = TreeNode(1, 3)
        val leftChild = TreeNode(2, 2)
        val rightChild = TreeNode(3, 2)
        val leftLeftChild = TreeNode(4, 0)
        val leftRightChild = TreeNode(5, 0)
        val rightLeftChild = TreeNode(6, 0)
        val rightRightChild = TreeNode(7, 0)

        root.left = leftChild
        root.right = rightChild

        leftChild.left = leftLeftChild
        leftChild.right = leftRightChild

        rightChild.left = rightLeftChild
        rightChild.right = rightRightChild

        assertEquals(leftLeftChild, solution.findNthInorderTreeNode(1, root)!!)
        assertEquals(leftChild, solution.findNthInorderTreeNode(2, root)!!)
        assertEquals(leftRightChild, solution.findNthInorderTreeNode(3, root)!!)
        assertEquals(root, solution.findNthInorderTreeNode(4, root)!!)
        assertEquals(rightLeftChild, solution.findNthInorderTreeNode(5, root)!!)
        assertEquals(rightChild, solution.findNthInorderTreeNode(6, root)!!)
        assertEquals(rightRightChild, solution.findNthInorderTreeNode(7, root)!!)
    }
}