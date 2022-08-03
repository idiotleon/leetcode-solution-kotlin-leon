package com.an7one.leetcode.lvl3.lc0948

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/bag-of-tokens/
 *
 * Time Complexity:     O(`nTokens` * lg(`nTokens`))
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/bag-of-tokens/discuss/197696/C%2B%2BJavaPython-Greedy-%2B-Two-Pointers
 */
@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun bagOfTokensScore(tokens: IntArray, P: Int): Int {
        val nTokens = tokens.size
        tokens.sort()

        var lo = 0
        var hi = nTokens - 1
        var power = P
        var points = 0

        var mostPoints = 0

        while (lo <= hi) {
            if (power >= tokens[lo]) {
                power -= tokens[lo++]
                mostPoints = maxOf(mostPoints, ++points)
            } else if (points > 0) {
                power += tokens[hi--]
                --points
            } else break
        }

        return mostPoints
    }
}