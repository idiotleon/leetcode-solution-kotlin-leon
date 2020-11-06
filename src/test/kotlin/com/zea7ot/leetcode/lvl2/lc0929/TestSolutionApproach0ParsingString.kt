package com.zea7ot.leetcode.lvl2.lc0929

import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0ParsingString {
    private val solution = SolutionApproach0ParsingString()

    @Test
    fun test_SampleInput1_ShouldReturnExpected() {
        val input = arrayOf("test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com")

        val expected = 1

        assertEquals(expected, solution.numUniqueEmails(input))
    }
}