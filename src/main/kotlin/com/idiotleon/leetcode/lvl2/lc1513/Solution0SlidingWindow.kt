package com.idiotleon.leetcode.lvl2.lc1513

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-substrings-with-only-1s/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0SlidingWindow {
    private companion object {
        private const val ONE = '1'

        private const val MOD = 1e9.toLong() + 7
    }

    fun numSub(s: String): Int {
        val lenS = s.length

        var len = 0
        var count = 0L
        for (ch in s) {
            when (ch) {
                ONE -> {
                    ++len
                }

                else -> {
                    count = (count + getCount(len)) % MOD
                    len = 0
                }
            }
        }

        if (len > 0) {
            count = (count + getCount(len)) % MOD
        }

        return count.toInt()
    }

    // to prevent integer overflow
    private fun getCount(len: Int): Long = (len.toLong() + 1) * len.toLong() / 2
}