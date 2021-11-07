/**
 * https://leetcode.com/problems/matchsticks-to-square/
 *
 * Time Complexity:     O(4 ^ `sumAll`)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/108741/Solution-with-Reference/569560
 *  https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/108741/Solution-with-Reference
 */
package com.an7one.leetcode.lvl4.lc0473

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack0 {
    fun makeSquare(nums: IntArray): Boolean {
        val nNums = nums.size

        val sumAll = nums.sum()
        if (sumAll < 4 || sumAll % 4 != 0)
            return false

        val sumTarget = sumAll / 4
        val used = BooleanArray(nNums) { false }

        return canPartition(0, 0, 4, used, sumTarget, nums)
    }

    private fun canPartition(
        idxStart: Int,
        sumCur: Int,
        k: Int,
        used: BooleanArray,
        sumTarget: Int,
        nums: IntArray
    ): Boolean {
        val nNums = nums.size

        if (k == 0)
            return true
        // one partition has been found (`k - 1`), to find the next one
        if (sumCur == sumTarget)
            return canPartition(0, 0, k - 1, used, sumTarget, nums)

        if (sumCur > sumTarget)
            return false

        for (idx in idxStart until nNums) {
            if (used[idx])
                continue
            // to mark visited
            used[idx] = true
            // to further backtrack to the next state
            if (canPartition(1 + idx, sumCur + nums[idx], k, used, sumTarget, nums))
                return true
            // to backtrack to the previous state
            used[idx] = false
        }

        return false
    }
}