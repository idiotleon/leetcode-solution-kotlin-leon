package com.zea7ot.leetcode.lvl1.lc1290

import com.zea7ot.leetcode.utils.dataStructure.linkedList.ListNode
import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0DFS {
    private val solution = SolutionApproach0DFS()

    @Test
    fun test_SampleInput1_ShouldReturnExpected() {
        val nums = intArrayOf(1, 0, 1)
        val head = ListNode.constructLinkedList(nums)

        val expected = 5
        assertEquals(expected, solution.getDecimalValue(head))
    }

    @Test
    fun test_SampleInput4_ShouldReturnExpected() {
        val nums = intArrayOf(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0)
        val head = ListNode.constructLinkedList(nums)

        val expected = 18880
        assertEquals(expected, solution.getDecimalValue(head))
    }
}