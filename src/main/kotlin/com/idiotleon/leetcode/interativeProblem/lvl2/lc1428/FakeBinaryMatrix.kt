package com.idiotleon.leetcode.interativeProblem.lvl2.lc1428

class FakeBinaryMatrix {
    fun get(row: Int, col: Int): Int = row + col + 1

    fun dimensions(): List<Int> = listOf(0, 1)
}