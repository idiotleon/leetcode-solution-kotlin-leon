package com.an7one.leetcode.lvl6.lc0470

import com.an7one.leetcode.lvl6.lc0471.SolutionApproach0DP2DimenWithKMP
import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0DP2DimenWithKMP {
    private val solution = SolutionApproach0DP2DimenWithKMP()

    @Test
    fun test_RegularInput_ShouldReturnExpected() {
        val str = "aaaaa"
        val expected = "5[a]"

        assertEquals(expected, solution.encode(str))
    }
}