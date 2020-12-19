/**
 * https://leetcode.com/problems/greatest-sum-divisible-by-three/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/greatest-sum-divisible-by-three/discuss/431108/Java-O(N)-solution-Simple-Math-O(1)-space
 */
package com.zea7ot.leetcode.lvl3.lc1262.followups.followup0

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun maxSumDivK(nums: IntArray, K: Int): Int {
        // not used
        // val totalNums = nums.size

        var dp = intArrayOf(0, Int.MIN_VALUE, Int.MIN_VALUE)
        for (num in nums) {
            val next = IntArray(K)
            for (remainder in 0 until K) {
                next[(num + remainder) % K] = maxOf(dp[(num + remainder) % K], dp[remainder] + num)
            }

            dp = next
        }

        return dp[0]
    }
}