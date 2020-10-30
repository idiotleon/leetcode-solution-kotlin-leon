/**
 * https://leetcode.com/problems/rle-iterator/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/rle-iterator/discuss/168294/Java-Straightforward-Solution-O(n)-time-O(1)-space
 */
package com.zea7ot.leetcode.ood.lvl3.lc0900

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan(private val nums: IntArray) {
    private var idx = 0

    fun next(n: Int): Int {
        val totalNums = nums.size
        var iter = n
        while (idx < totalNums && iter > nums[idx]) {
            iter -= nums[idx]
            idx += 2
        }

        if (idx >= totalNums) return -1

        nums[idx] -= iter
        return nums[idx + 1]
    }
}