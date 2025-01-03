package com.idiotleon.leetcode.lvl1.lc2011

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
 *
 * Time Complexity:     O(`nOps`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    private companion object {
        private const val PLUS = '+'
        private const val MINUS = '-'
    }

    fun finalValueAfterOperations(operations: Array<String>): Int {
        val nOps = operations.size
        var count = 0
        for (operation in operations) {
            when (operation[1]) {
                PLUS -> ++count
                MINUS -> --count
                else -> {}
            }
        }

        return count
    }
}