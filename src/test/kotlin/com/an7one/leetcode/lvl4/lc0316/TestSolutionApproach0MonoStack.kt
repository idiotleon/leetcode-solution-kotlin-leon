package com.an7one.leetcode.lvl4.lc0316

import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0MonoStack {
    private val solution = SolutionApproach0MonoStack()

    @Test
    fun test() {
        val input = "cdadabcc"
        val expected = "adbc"

        assertEquals(expected, solution.removeDuplicateLetters(input))
    }
}