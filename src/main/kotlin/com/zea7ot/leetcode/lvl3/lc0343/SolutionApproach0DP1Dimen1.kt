/**
 * https://leetcode.com/problems/integer-break/
 *
 * Time Complexity:     O(`n` ^ 2)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/integer-break/discuss/80694/Java-DP-solution/85260
 */
package com.zea7ot.leetcode.lvl3.lc0343

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen1 {
    fun integerBreak(n: Int): Int {
        val maxProds = IntArray(n + 1) { idx -> if (idx < n) idx else 0 }

        for (hi in 2..n) {
            var lo = 1
            while (lo <= hi - lo) {
                maxProds[hi] = maxOf(maxProds[hi], maxProds[lo] * maxProds[hi - lo])
                ++lo
            }
        }

        return maxProds[n]
    }
}