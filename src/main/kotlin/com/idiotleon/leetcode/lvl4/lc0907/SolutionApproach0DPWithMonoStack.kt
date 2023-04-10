package com.idiotleon.leetcode.lvl4.lc0907

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * `dp[idx + 1]`: sum of minimum of subarrays which ends with `nums[idx]`
 *
 * Reference:
 * https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170769/Java-O(n)-monotone-stack-with-DP
 */
@Suppress(UNUSED)
class SolutionApproach0DPWithMonoStack {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun sumSubarrayMins(nums: IntArray): Int {
        val nNums = nums.size

        var sum = 0
        val dp = IntArray(nNums + 1) { 0 }

        val stack = ArrayDeque<Int>().also {
            it.addLast(-1)
        }

        for (idx in nums.indices) {
            while (stack.last() != -1 && nums[idx] <= nums[stack.last()]) {
                stack.removeLast()
            }

            dp[idx + 1] = (dp[stack.last() + 1] + (idx - stack.last()) * nums[idx]) % MOD
            stack.addLast(idx)

            sum += dp[idx + 1]
            sum %= MOD
        }

        return sum
    }
}