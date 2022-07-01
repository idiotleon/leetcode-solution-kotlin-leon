package com.an7one.leetcode.lvl3.lc0039

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/combination-sum/
 *
 * Time Complexity:     O(`nNums` * `target` * `nNums`) ~ O((`nNums` ^ 2) * `target`)
 * Space Complexity:    O(`target` * `nNums` * `nNums`) ~ O((`nNums` ^ 2) * `target`)
 *
 * Reference:
 * https://leetcode.com/problems/combination-sum/solution/683656
 * https://leetcode.com/problems/combination-sum/solution/
 */
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