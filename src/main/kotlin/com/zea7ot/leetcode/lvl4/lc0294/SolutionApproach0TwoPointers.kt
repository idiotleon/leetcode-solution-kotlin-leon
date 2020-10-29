/**
 * https://leetcode.com/problems/flip-game-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/flip-game-ii/discuss/73958/Memoization:-3150ms-greater-130ms-greater-44ms-(Python)/76951
 */
package com.zea7ot.leetcode.lvl4.lc0294

class SolutionApproach0TwoPointers {
    private companion object {
        private const val SIGN_PLUS = '+'
        private const val SIGN_MINUS = '-'
    }

    fun canWin(s: String): Boolean {
        val lenS = s.length

        var flips = 0
        var change = 0

        var lo = 0
        var hi = 0

        while (hi < lenS) {
            lo = s.indexOf(SIGN_PLUS, lo)
            if (lo == -1) break

            hi = s.indexOf(SIGN_MINUS, lo)
            if (hi == -1) hi = lenS

            if (hi - lo == 2) ++flips
            else if (hi - lo == 4 || hi - lo == 6) ++change

            flips += (hi - lo - 1) / 2

            lo = hi
            ++hi
        }

        return change % 2 != 0 || flips % 2 != 0
    }
}