/**
 * https://leetcode.com/problems/partition-array-into-disjoint-intervals/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/partition-array-into-disjoint-intervals/discuss/175945/Java-one-pass-7-lines/464700
 *  https://leetcode.com/problems/partition-array-into-disjoint-intervals/discuss/175945/Java-one-pass-7-lines/240935
 *  https://leetcode.com/problems/partition-array-into-disjoint-intervals/discuss/175945/Java-one-pass-7-lines
 */
package com.idiotleon.leetcode.lvl4.lc0915

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun partitionDisjoint(nums: IntArray): Int {
        val nNums = nums.size

        var curMax = nums[0]
        var prevMax = nums[0]
        var idxPartition = 1

        for (idx in 1 until nNums) {
            if (nums[idx] < prevMax) {
                idxPartition = idx + 1
                prevMax = curMax
            } else
                curMax = maxOf(curMax, nums[idx])
        }

        return idxPartition
    }
}