package com.idiotleon.leetcode.lvl3.lc2116

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * Reference:
 * https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/solutions/6267067/simple-balance-check-detailed-solution/
 */
@Suppress(UNUSED)
class Solution0LinearScanWithStack {
    private companion object {
        private const val OPEN = '('
        private const val CLOSED = ')'

        private const val LOCKED = '1'
        private const val UNLOCKED = '0'
    }

    fun canBeValid(s: String, locked: String): Boolean {
        val lenS = s.length

        val openIndices = ArrayDeque<Int>(lenS)
        val unlockedIndices = ArrayDeque<Int>(lenS)

        for ((idx, ch) in s.withIndex()) {
            if (locked[idx] == UNLOCKED) {
                unlockedIndices.addLast(idx)
            } else {
                when (ch) {
                    OPEN -> {
                        openIndices.addLast(idx)
                    }

                    CLOSED -> {
                        if (openIndices.isNotEmpty()) {
                            openIndices.removeLast()
                        } else if (unlockedIndices.isNotEmpty()) {
                            unlockedIndices.removeLast()
                        } else {
                            return false
                        }
                    }

                    else -> {}
                }
            }
        }

        // to match the remaining open parenthesis
        while (openIndices.isNotEmpty() && unlockedIndices.isNotEmpty() && openIndices.last() < unlockedIndices.last()) {
            openIndices.removeLast()
            unlockedIndices.removeLast()
        }

        if (openIndices.isEmpty() && unlockedIndices.isNotEmpty()) {
            return unlockedIndices.size % 2 == 0
        }

        return openIndices.isEmpty()
    }
}