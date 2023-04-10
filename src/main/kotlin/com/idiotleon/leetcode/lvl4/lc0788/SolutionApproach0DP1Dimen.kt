/**
 * https://leetcode.com/problems/rotated-digits/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://leetcode.com/problems/rotated-digits/discuss/117975/Java-dp-solution-9ms
 *  http://www.frankmadrid.com/ALudicFallacy/2018/02/28/rotated-digits-leet-code-788/
 */
package com.idiotleon.leetcode.lvl4.lc0788

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    private companion object {
        private const val INVALID = 0
        private const val VALID_SAME = 1
        private const val VALID_DIFF = 2
    }

    fun rotatedDigits(N: Int): Int {
        val dp = IntArray(N + 1)
        var count = 0

        for (num in 0..N) {
            if (num < 10) {
                when (num) {
                    0, 1, 8 -> dp[num] = VALID_SAME
                    2, 5, 6, 9 -> {
                        dp[num] = VALID_DIFF
                        ++count
                    }
                }
            } else {
                val a = dp[num / 10]
                val b = dp[num % 10]

                when {
                    a == 1 && b == 1 -> dp[num] = VALID_SAME
                    a >= 1 && b >= 1 -> {
                        dp[num] = VALID_DIFF
                        ++count
                    }
                    else -> {
                    }
                }
            }
        }

        return count
    }
}