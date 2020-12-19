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
class SolutionApproach0BrutalForce1 {
    private companion object {
        private const val SIGN_PLUS = '+'
        private const val SIGN_MINUS = '-'
    }

    fun generatePossibleNextMoves(s: String): List<String> {
        val lenS = s.length

        val ans = ArrayList<String>()
        for (idx in 1 until lenS) {
            if (s[idx] == SIGN_PLUS && s[idx - 1] == SIGN_PLUS) {
                ans.add(s.substring(0, idx - 1) + SIGN_MINUS + SIGN_MINUS + s.substring(idx + 1, lenS))
            }
        }

        return ans
    }
}