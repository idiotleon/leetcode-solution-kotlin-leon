/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 *
 * Time Complexity:     O(`k` ^ `nNums`)
 * Space Complexity:    O(`k`)
 *
 * References:
 *  https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/108741/Solution-with-Reference/569560
 *  https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/108741/Solution-with-Reference
 */
package com.an7one.leetcode.lvl4.lc0698

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack0 {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        val nNums = nums.size
        val sumAll = nums.sum()
        if (sumAll < k || sumAll % k != 0)
            return false

        val used = BooleanArray(nNums) { false }

        return canPartition(0, 0, used, k, sumAll / k, nums)
    }

    private fun canPartition(
        idxStart: Int,
        sumCur: Int,
        used: BooleanArray,
        k: Int,
        target: Int,
        nums: IntArray
    ): Boolean {
        val nNums = nums.size

        if (k == 0)
            return true

        if (sumCur == target)
            return canPartition(0, 0, used, k - 1, target, nums)

        if (sumCur > target)
            return false

        for (idx in idxStart until nNums) {
            if (used[idx])
                continue

            used[idx] = true
            if (canPartition(1 + idx, sumCur + nums[idx], used, k, target, nums))
                return true
            used[idx] = false
        }

        return false
    }
}