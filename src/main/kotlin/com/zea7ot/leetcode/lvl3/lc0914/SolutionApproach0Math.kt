/**
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 *
 * Time Complexity:     O(`totalCards`)
 * Space Complexity:    O(`totalCards`)
 *
 * References:
 *  https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/discuss/175845/C%2B%2BJavaPython-Greatest-Common-Divisor
 */
package com.zea7ot.leetcode.lvl3.lc0914

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun hasGroupsSizeX(deck: IntArray): Boolean {
        // not used
        // val totalCards = deck.size

        val freqs = HashMap<Int, Int>()
        var res = 0

        for (card in deck) freqs[card] = 1 + (freqs[card] ?: 0)

        for ((_, freq) in freqs) {
            res = gcd(freq, res)
        }

        return res > 1
    }

    private fun gcd(a: Int, b: Int): Int {
        if (a == 0) return b
        return gcd(b % a, a)
    }
}