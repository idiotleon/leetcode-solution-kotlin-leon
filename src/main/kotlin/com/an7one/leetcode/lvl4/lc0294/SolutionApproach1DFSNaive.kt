package com.an7one.leetcode.lvl4.lc0294

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/flip-game-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/flip-game-ii/discuss/73962/Share-my-Java-backtracking-solution
 */
@Suppress(UNUSED)
class SolutionApproach1DFSNaive {
    private companion object {
        private const val DOUBLE_PLUSES = "++"
        private const val DOUBLE_MINUSES = "--"
    }

    fun canWin(s: String): Boolean {
        if (s.isEmpty() || s.length < 2) return false
        return dfs(s)
    }

    private fun dfs(str: String): Boolean {
        val lenS = str.length
        for (idx in 0 until lenS - 1) {
            if (str.startsWith(DOUBLE_PLUSES, idx)) {
                val flipped = str.substring(0, idx) + DOUBLE_MINUSES + str.substring(idx + 2)

                if (!dfs(flipped)) return true
            }
        }
        return false
    }
}