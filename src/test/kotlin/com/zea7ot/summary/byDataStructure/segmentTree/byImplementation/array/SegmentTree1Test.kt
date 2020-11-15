package com.zea7ot.summary.byDataStructure.segmentTree.byImplementation.array

import com.zea7ot.summary.byDataStructure.segmentTree.byImplementation.array.rangeSum.SegmentTree1
import org.junit.Test
import kotlin.test.assertEquals

internal class SegmentTree1Test {
    private val nums = intArrayOf(1, 3, 5, 7, 9, 11)

    @Test
    fun test_BuildTree_ShouldBehaveExpected() {
        val segmentTree = SegmentTree1(nums)
        // val expected = intArrayOf(36, 9, 27, 4, 5, 16, 11, 1, 3, 0, 0, 7, 9, 0, 0)

        val expected = 36

        assertEquals(expected, segmentTree.query(0, nums.lastIndex))
    }

    @Test
    fun test_UpdateTree_ShouldBehaveExpected() {
        val segmentTree = SegmentTree1(nums)
        segmentTree.update(4, 6)

        // val expected = intArrayOf(33, 9, 24, 4, 5, 13, 11, 1, 3, 0, 0, 7, 6, 0, 0)
        val expected = 33

        assertEquals(expected, segmentTree.query(0, nums.lastIndex))
    }

    @Test
    fun test_QueryTree_ShouldReturnExpected() {
        val segmentTree = SegmentTree1(nums)

        val expected = 32

        assertEquals(expected, segmentTree.query(2, 5))
    }
}