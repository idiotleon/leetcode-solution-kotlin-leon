/**
 * https://leetcode.com/problems/combination-sum/
 *
 * Time Complexity:     O(`nNums` * `target` * `nNums`) ~ O((`nNums` ^ 2) * `target`)
 * Space Complexity:    O(`target` * `nNums` * `nNums`) ~ O((`nNums` ^ 2) * `target`)
 *
 * References:
 *  https://leetcode.com/problems/combination-sum/solution/683656
 *  https://leetcode.com/problems/combination-sum/solution/
 */
package com.zea7ot.leetcode.lvl3.lc0039

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP3Dimen {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        // not used
        // val nNums = nums.size
        val dp = Array(target + 1) { mutableListOf<MutableList<Int>>() }
        dp[0].add(mutableListOf())

        for (num in nums) {
            for (sum in num..target) {
                for (comb in dp[sum - num]) {
                    val newComb = comb.toMutableList().also { it.add(num) }
                    dp[sum].add(newComb)
                }
            }
        }

        return dp[target]
    }
}