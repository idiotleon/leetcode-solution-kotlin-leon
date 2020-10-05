/**
 * https://leetcode.com/problems/largest-divisible-subset/
 *
 * Time Complexity:     O(`totalNums` ^ 2) + O(`totalNums` * lg(`totalNums`)) ~ O(`totalNums` ^ 2)
 * Space Complexity:    O(`totalNums`)
 *
 * `dp[i]`, the length of the longest divisible subset ending with nums[i]
 *
 * References:
 *  https://leetcode.com/problems/largest-divisible-subset/discuss/83999/Easy-understood-Java-DP-solution-in-28ms-with-O(n2)-time
 *  https://youtu.be/FLbqgyJ-70I?t=3068
 */
package com.zea7ot.lc.lvl4.lc0368

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        val ans = arrayListOf<Int>()
        // sanity check
        if (nums.isEmpty()) return ans

        val totalNums = nums.size
        nums.sort()
        val dp = IntArray(totalNums) { 1 }

        for (hi in 1 until totalNums) {
            for (lo in hi - 1 downTo 0) {
                if (nums[hi] % nums[lo] == 0) {
                    dp[hi] = maxOf(dp[hi], dp[lo] + 1)
                }
            }
        }

        var idxMaxLen = 0
        for (i in 1 until totalNums) {
            idxMaxLen = if (dp[i] > dp[idxMaxLen]) i else idxMaxLen
        }
        // or equivalently, O(`totalNums`), with one pass only
        // var idxMaxLen = dp.indices.maxBy{ dp[it] } ?: -1

        var maxLenTail = nums[idxMaxLen]
        var curMaxLen = dp[idxMaxLen]

        for (i in idxMaxLen downTo 0) {
            if (maxLenTail % nums[i] == 0 && dp[i] == curMaxLen) {
                ans.add(nums[i])
                maxLenTail = nums[i]
                --curMaxLen
            }
        }

        return ans
    }
}