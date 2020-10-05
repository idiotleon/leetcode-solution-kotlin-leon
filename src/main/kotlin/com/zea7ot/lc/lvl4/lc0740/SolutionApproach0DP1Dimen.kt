/**
 * https://leetcode.com/problems/delete-and-earn/
 *
 * Time Complexity:     O(totalNums + `RANGE`) + O(`RANGE`) ~ O(totalNums + `RANGE`)
 *  totalNums, the amount of elements in the input array
 *  RANGE, the range of the value of each integer element, which, in this case, is 10001,
 *      and can be optimized to the max value in the array, at an extra cost of O(N)
 *
 * Space Complexity:    O(totalNums + `RANGE`)
 *
 * References:
 *  https://leetcode.com/problems/delete-and-earn/discuss/109889/Java-Easy-DP-Solution/111623
 *  https://www.youtube.com/watch?v=YzZd-bsMthk
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-740-delete-and-earn/
 */
package com.zea7ot.lc.lvl4.lc0740

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun deleteAndEarn(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val totalRange = 1e4.toInt() + 1

        val sums = IntArray(totalRange)
        for (num in nums) {
            sums[num] += num
        }

        val dp = IntArray(totalRange)
        dp[1] = sums[1]

        for (i in 2 until totalRange) {
            dp[i] = maxOf(dp[i - 1], dp[i - 2] + sums[i])
        }

        return dp[totalRange - 1]
    }
}