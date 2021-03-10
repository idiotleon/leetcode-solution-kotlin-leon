package com.an7one.summary.byDataStructure.tree.segmentTree.array

import com.an7one.summary.byDataStructure.tree.segmentTree.array.rangeSum.SegmentTree
import org.junit.Test
import kotlin.test.assertEquals

internal class SegmentTreeTest {
    private val nums = intArrayOf(1, 3, 5, 7, 9, 11)

    @Test
    fun test_BuildTree_ShouldBehaveExpected() {
        val segmentTree = SegmentTree(nums)
        // val expected = intArrayOf(36, 9, 27, 4, 5, 16, 11, 1, 3, 0, 0, 7, 9, 0, 0)
        val expected = 36

        assertEquals(expected, segmentTree.query(0, nums.lastIndex))
    }

    @Test
    fun test_UpdateTree_ShouldBehaveExpected() {
        val segmentTree = SegmentTree(nums)
        segmentTree.update(4, 6)

        // val expected = intArrayOf(33, 9, 24, 4, 5, 13, 11, 1, 3, 0, 0, 7, 6, 0, 0)
        val expected = 33

        assertEquals(expected, segmentTree.query(0, nums.lastIndex))
    }

    @Test
    fun test_QueryTree_ShouldReturnExpected() {
        val segmentTree = SegmentTree(nums)

        val expected = 32

        assertEquals(expected, segmentTree.query(2, 5))
    }
}