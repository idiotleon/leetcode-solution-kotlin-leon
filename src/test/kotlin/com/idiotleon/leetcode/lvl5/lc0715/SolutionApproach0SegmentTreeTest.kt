package com.idiotleon.leetcode.lvl5.lc0715

import org.junit.Test
import kotlin.test.assertTrue


internal class SolutionApproach0SegmentTreeTest {
    val solution = SolutionApproach0SegmentTree()

    @Test
    fun addRange_SampleInput1_ShouldReturnExpected() {
        solution.addRange(10, 20)

        assertTrue(solution.queryRange(10, 14))
    }
}