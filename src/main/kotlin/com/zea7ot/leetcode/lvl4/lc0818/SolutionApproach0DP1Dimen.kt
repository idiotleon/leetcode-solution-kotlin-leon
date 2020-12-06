/**
 * https://leetcode.com/problems/race-car/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/race-car/discuss/246138/java-DP-solution-heavily-commented.
 *  http://zxi.mytechroad.com/blog/graph/leetcode-818-race-car/
 *  https://leetcode.com/problems/race-car/discuss/227415/Figures-to-make-the-DP-solution-more-straightforward
 *  https://leetcode.com/problems/race-car/discuss/124326/Summary-of-the-BFS-and-DP-solutions-with-intuitive-explanation
 */
package com.zea7ot.leetcode.lvl4.lc0818

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun racecar(target: Int): Int {
        if (target == 0) return 0

        val dp = IntArray(target + 1) { 0 }

        for (dest in 1..target) {
            var hiPos = 0
            var hiSteps = 0
            while (hiPos < dest) {
                ++hiSteps
                hiPos = (1 shl hiSteps) - 1
            }

            if (hiPos == dest) {
                dp[dest] = hiSteps
                continue
            }

            dp[dest] = hiSteps + 1 + dp[hiPos - dest]

            val loSteps = hiSteps - 1
            val loPos = (1 shl loSteps) - 1

            for (steps in 0 until loSteps) {
                val reversePos = loPos - ((1 shl steps) - 1)
                dp[dest] = minOf(dp[dest], loSteps + 1 + steps + 1 + dp[dest - reversePos])
            }
        }

        return dp[target]
    }
}