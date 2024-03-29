package com.idiotleon.leetcode.lvl4.lc0294

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/flip-game-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/flip-game-ii/discuss/73962/Share-my-Java-backtracking-solution/77005
 * https://leetcode.com/problems/flip-game-ii/discuss/73962/Share-my-Java-backtracking-solution
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    private companion object {
        private const val SIGN_PLUS = '+'
        private const val SIGN_MINUS = '-'
    }

    fun canWin(s: String): Boolean {
        if (s.isEmpty() || s.length < 2) return false
        val memo = HashMap<String, Boolean>()
        return canWin(s, memo)
    }

    private fun canWin(str: String, memo: HashMap<String, Boolean>): Boolean {
        memo[str]?.let { return it }
        val lenS = str.length
        for (idx in 0 until lenS - 1) {
            if (str[idx] == SIGN_PLUS && str[idx + 1] == SIGN_PLUS) {
                val flipped = str.substring(0, idx) + SIGN_MINUS + SIGN_MINUS + str.substring(idx + 2)
                if (!canWin(flipped, memo)) {
                    memo[str] = true
                    return true
                }
            }
        }
        memo[str] = false
        return false
    }
}