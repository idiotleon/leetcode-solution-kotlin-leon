/**
 * https://leetcode.com/problems/greatest-sum-divisible-by-three/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * `dp[i]`, the sum based on remainders(i) mod by `K`
 *
 * References:
 *  https://leetcode.com/problems/greatest-sum-divisible-by-three/discuss/431077/JavaC++Python-One-Pass-O(1)-space/387990
 */
package com.an7one.leetcode.lvl3.lc1262

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen1 {
    private companion object {
        private const val K = 3
    }

    fun maxSumDivThree(nums: IntArray): Int {
        // not used
        // val totalNums = nums.size

        var dp = IntArray(K)
        for (num in nums) {
            val next = dp.copyOf()
            for (sum in dp) {
                val nSum = sum + num
                val idx = nSum % K
                next[idx] = maxOf(nSum, next[idx])
            }

            dp = next
        }

        return dp[0]
    }
}