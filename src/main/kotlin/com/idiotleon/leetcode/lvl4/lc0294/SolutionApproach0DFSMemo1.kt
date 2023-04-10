package com.idiotleon.leetcode.lvl4.lc0294

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/flip-game-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/flip-game-ii/discuss/73962/Share-my-Java-backtracking-solution/77009
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo1 {
    private companion object {
        private const val SIGN_PLUS = '+'
        private const val SIGN_MINUS = '-'
    }

    fun canWin(s: String): Boolean {
        if (s.isEmpty() || s.length < 2) return false
        val winSet = HashSet<String>()
        return canWin(s, winSet)
    }

    private fun canWin(str: String, winSet: HashSet<String>): Boolean {
        if (winSet.contains(str)) return true

        val lenS = str.length

        for (idx in 0 until lenS - 1) {
            if (str[idx] == SIGN_PLUS && str[idx + 1] == SIGN_PLUS) {
                val flipped = str.substring(0, idx) + SIGN_MINUS + SIGN_MINUS + str.substring(idx + 2)
                if (!canWin(flipped, winSet)) {
                    winSet.add(str)
                    return true
                }
            }
        }

        return false
    }
}