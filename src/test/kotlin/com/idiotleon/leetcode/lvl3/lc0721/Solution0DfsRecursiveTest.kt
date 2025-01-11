package com.idiotleon.leetcode.lvl3.lc0721

import kotlin.test.Test
import kotlin.test.assertEquals

internal class Solution0DfsRecursiveTest {
    private val solution = Solution0DfsRecursive()

    @Test
    fun accoutsMerge_SampleInput0_ShouldReturnExpected() {
        val input = listOf(
            listOf("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            listOf("John", "johnsmith@mail.com", "john00@mail.com"),
            listOf("Mary", "mary@mail.com"),
            listOf("John", "johnnybravo@mail.com")
        )

        val expected = listOf(
            listOf("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
            listOf("Mary", "mary@mail.com"), listOf("John", "johnnybravo@mail.com")
        )

        assertEquals(expected, solution.accountsMerge(input))
    }
}