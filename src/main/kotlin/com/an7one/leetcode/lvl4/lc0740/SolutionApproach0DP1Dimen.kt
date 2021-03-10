/**
 * https://leetcode.com/problems/delete-and-earn/
 *
 * Time Complexity:     O(`nNums` + `RANGE`) + O(`RANGE`) ~ O(`nNums` + `RANGE`)
 *  nNums, the amount of elements in the input array
 *  RANGE, the range of the value of each integer element, which, in this case, is 10001,
 *      and can be optimized to the max value in the array, at an extra cost of O(totalNums)
 *
 * Space Complexity:    O(`nNums` + `RANGE`)
 *
 *
 * References:
 *  https://leetcode.com/problems/delete-and-earn/discuss/109889/Java-Easy-DP-Solution/111623
 *  https://www.youtube.com/watch?v=YzZd-bsMthk
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-740-delete-and-earn/
 */
package com.an7one.leetcode.lvl4.lc0740

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun deleteAndEarn(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        val valueRange = 1e4.toInt() + 1

        val numToSums = IntArray(valueRange)
        for (num in nums) {
            numToSums[num] += num
        }

        val dp = IntArray(valueRange) { 0 }
        dp[1] = numToSums[1]

        for (idx in 2 until valueRange) {
            dp[idx] = maxOf(dp[idx - 1], dp[idx - 2] + numToSums[idx])
        }

        return dp.last()
    }
}