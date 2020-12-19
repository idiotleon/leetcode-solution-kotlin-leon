/**
 * https://leetcode.com/problems/flip-game/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/flip-game/discuss/73902/Simple-solution-in-Java
 */
package com.zea7ot.leetcode.lvl1.lc0293

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BrutalForce2 {
    private companion object {
        private const val DOUBLE_PLUSES = "++"
        private const val DOUBLE_MINUSES = "--"
    }

    fun generatePossibleNextMoves(s: String): List<String> {
        val lenS = s.length

        val ans = ArrayList<String>()
        for (idx in 2..lenS) {
            if (s.substring(idx - 2, idx) == DOUBLE_PLUSES) {
                ans.add(s.substring(0, idx - 2) + DOUBLE_MINUSES + s.substring(idx, lenS))
            }
        }

        return ans
    }
}