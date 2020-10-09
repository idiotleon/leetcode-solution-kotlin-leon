/**
 * https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/discuss/377397/Intuitive-Java-Solution-With-Explanation/392667
 *  https://youtu.be/FLbqgyJ-70I?t=2381
 */
package com.zea7ot.leetcode.lvl4.lc1186

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun maximumSum(nums: IntArray): Int {

        val totalNums = nums.size

        // the maximum subarray sum with no deletion
        var noDeletion = nums[0]
        // the maximum subarray sum with one deletion
        var oneDeletion = 0

        // the maximum subarray sum
        var maxSum = nums[0]

        for (idx in 1 until totalNums) {
            oneDeletion = maxOf(noDeletion, oneDeletion + nums[idx])
            noDeletion = maxOf(noDeletion + nums[idx], nums[idx])

            maxSum = maxOf(maxSum, oneDeletion, noDeletion)
        }

        return maxSum
    }
}