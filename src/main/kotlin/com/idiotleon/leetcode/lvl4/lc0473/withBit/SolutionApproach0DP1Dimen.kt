/**
 * https://leetcode.com/problems/matchsticks-to-square/
 *
 * Time Complexity:     O(4 ^ `nNums`)
 * Space Complexity:    O(`range`)
 *
 * References:
 *  https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/335668/DP-with-Bit-Masking-Solution-%3A-Best-for-Interviews
 */
package com.idiotleon.leetcode.lvl4.lc0473.withBit

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun makeSquare(nums: IntArray): Boolean {
        // sanity check, required
        if (nums.isEmpty())
            return false

        return canPartitionKSubsets(nums, 4)
    }

    // the solution for lc0698
    private fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        val nNums = nums.size
        // the range of states(bitmask)
        val range = 1 shl nNums

        // whether it can be partitioned, corresponding to the state (bitmask)
        val dp = BooleanArray(range) { false }.also {
            it[0] = true
        }
        // the sums, corresponding to the state (bitmask)
        val sums = IntArray(range) { 0 }

        val sum = nums.sum()
        if (sum % k != 0)
            return false

        val target = sum / k
        nums.sort()
        if (nums.last() > target)
            return false

        for (cur in 0 until range) {
            if (dp[cur]) { // if with the cur state, it can be partitioned
                // to try to find the next state
                for (idx in nums.indices) {
                    // to sum/take the idx-th bit
                    val next = cur or (1 shl idx)
                    // if this number has been token before
                    if (cur == next)
                        continue

                    // if the current sum(`sums[cur]`),
                    // with this number (`nums[idx]`) being added,
                    // which is the next sum(`sums[next]`),
                    // still smaller or equal to the `target`
                    if (nums[idx] <= target - sums[cur] % target) {
                        dp[next] = true
                        sums[next] = nums[idx] + sums[cur]
                    } else
                        break
                }
            }
        }

        return dp[range - 1]
    }
}