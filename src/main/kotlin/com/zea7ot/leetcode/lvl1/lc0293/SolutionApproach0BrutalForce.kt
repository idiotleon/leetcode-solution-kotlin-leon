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
class SolutionApproach0BrutalForce {
    private companion object {
        private const val SIGN_PLUS = '+'
        private const val SIGN_MINUS = '-'
    }

    fun generatePossibleNextMoves(s: String): List<String> {
        val lenS = s.length

        val ans = ArrayList<String>()
        val chs = s.toCharArray()
        for (idx in 0 until lenS - 1) {
            if (chs[idx] == SIGN_PLUS && chs[idx + 1] == SIGN_PLUS) {
                chs[idx] = SIGN_MINUS
                chs[idx + 1] = SIGN_MINUS
                ans.add(String(chs))
                chs[idx] = SIGN_PLUS
                chs[idx + 1] = SIGN_PLUS
            }
        }

        return ans
    }
}