/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 *
 * Time Complexity:     O(`size` * `size`) ~ O(`size` ^ 2)
 * Space Complexity:    O(1) / O(`size` * `size`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-falling-path-sum/discuss/186666/C%2B%2BJava-4-lines-DP
 */
package com.zea7ot.leetcode.lvl3.lc0931

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minFallingPathSum(nums: Array<IntArray>): Int {
        // sanity check
        if (nums.isEmpty() || nums[0].isEmpty()) return 0

        // because it is a square
        val size = nums.size

        for (row in 1 until size) {
            for (col in 0 until size) {
                nums[row][col] += minOf(nums[row - 1][maxOf(0, col - 1)],
                        nums[row - 1][col],
                        nums[row - 1][minOf(size - 1, col + 1)])
            }
        }

        var minSum = Int.MAX_VALUE
        for (sum in nums[size - 1]) {
            minSum = minOf(minSum, sum)
        }
        return minSum
    }
}