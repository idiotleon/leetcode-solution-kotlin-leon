package com.zea7ot.leetcode.lvl2.lc1170

import org.junit.Test
import kotlin.test.assertTrue

class SolutionApproach0BinarySearchTest {
    private val solution = SolutionApproach0BinarySearch()

    @Test
    fun test_TestInput1_ShouldReturnExpected() {
        val queries = arrayOf("bba", "abaaaaaa", "aaaaaa", "bbabbabaab", "aba", "aa", "baab", "bbbbbb", "aab", "bbabbaabb")
        val words = arrayOf("aaabbb", "aab", "babbab", "babbbb", "b", "bbbbbbbbab", "a", "bbbbbbbbbb", "baaabbaab", "aa")

        val expected = intArrayOf(6, 1, 1, 2, 3, 3, 3, 1, 3, 2)

        assertTrue(expected contentEquals solution.numSmallerByFrequency(queries, words))
    }
}