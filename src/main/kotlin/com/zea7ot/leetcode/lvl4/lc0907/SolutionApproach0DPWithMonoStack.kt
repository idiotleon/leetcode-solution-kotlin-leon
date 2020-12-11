/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * dp[idx + 1]: sum of minimum of subarrays which ends with nums[idx]
 *
 * References:
 *  https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170769/Java-O(n)-monotone-stack-with-DP
 */
package com.zea7ot.leetcode.lvl4.lc0907

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DPWithMonoStack {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun sumSubarrayMins(nums: IntArray): Int {
        val nNums = nums.size

        var sum = 0
        val dp = IntArray(nNums + 1) { 0 }

        val stack = LinkedList<Int>().also {
            it.push(-1)
        }

        for (idx in nums.indices) {
            while (stack.peek() != -1 && nums[idx] <= nums[stack.peek()]) {
                stack.pop()
            }

            dp[idx + 1] = (dp[stack.peek() + 1] + (idx - stack.peek()) * nums[idx]) % MOD
            stack.push(idx)

            sum += dp[idx + 1]
            sum %= MOD
        }

        return sum
    }
}