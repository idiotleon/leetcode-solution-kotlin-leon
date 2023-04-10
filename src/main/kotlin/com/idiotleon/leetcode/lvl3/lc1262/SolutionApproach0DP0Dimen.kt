/**
 * https://leetcode.com/problems/greatest-sum-divisible-by-three/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/greatest-sum-divisible-by-three/discuss/431077/JavaC++Python-One-Pass-O(1)-space/389879
 *  https://leetcode.com/problems/greatest-sum-divisible-by-three/discuss/431077/JavaC%2B%2BPython-One-Pass-O(1)-space
 */
package com.idiotleon.leetcode.lvl3.lc1262

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    private companion object {
        private const val K = 3
    }

    fun maxSumDivThree(nums: IntArray): Int {
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