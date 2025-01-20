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
class Solution0LinearScan {
    private companion object {
        private const val ONE = '1'

        private const val MOD = 1e9.toInt() + 7
    }

    fun numSub(s: String): Int {
        val lenS = s.length

        var len = 0
        var count = 0
        for (ch in s) {
            when (ch) {
                ONE -> {
                    ++len
                    count = (count + len) % MOD
                }

                else -> {
                    len = 0
                }
            }
        }

        return count
    }
}