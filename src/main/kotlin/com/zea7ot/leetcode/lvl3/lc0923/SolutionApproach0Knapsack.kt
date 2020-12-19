/**
 * https://leetcode.com/problems/3sum-with-multiplicity/
 *
 * Time Complexity:     O(`totalNums` * 2 * `RANGE`) ~ O(`totalNums` * `RANGE`)
 * Space Complexity:    O(`RANGE` * 2) ~ O(`RANGE`)
 *
 * dp[sum][amount]:
 *   first dimension - `sum`: represents the actual sum
 *   second dimension - `amount`: represents the amount of numbers taken/considered
 *   value: represents the actual count/frequency
 *
 * References:
 *  https://leetcode.com/problems/3sum-with-multiplicity/discuss/181125/Knapsack-O(n-*-target)-or-Straightforward-O(n2)/257611
 */
package com.zea7ot.leetcode.lvl3.lc0923

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Knapsack {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
        private const val RANGE = 300 + 1
    }

    fun threeSumMulti(nums: IntArray, target: Int): Int {
        // not used
        // val totalNums = nums.size

        var count = 0
        // since it is about 3 sum,
        // this dp(IntArray) is used to keep track of the first two integer and their sums.
        val dp = Array(RANGE) { IntArray(2) { 0 } }

        for (num in nums) {
            // when `num` is considered as the third number
            if (target >= num) count += dp[target - num][1]
            count %= MOD

            // when `num` is considered as the first number", to try to find the "twoSum":
            // to seek `twoSum` in the range of possible two sums,
            // by adding the current `num` to the corresponding previous "oneSum"
            for (twoSum in target downTo num) {
                dp[twoSum][1] += dp[twoSum - num][0]
            }

            // when `num` is considered as the first number, to try to find the "oneSum"
            ++dp[num][0]
        }

        return count
    }
}