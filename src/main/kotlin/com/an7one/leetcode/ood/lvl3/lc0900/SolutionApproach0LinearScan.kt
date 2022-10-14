package com.an7one.leetcode.ood.lvl3.lc0900

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/rle-iterator/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`) / O(1)
 *
 * Reference:
 * https://leetcode.com/problems/rle-iterator/discuss/168294/Java-Straightforward-Solution-O(n)-time-O(1)-space
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan(private val nums: IntArray) {
    private var idx = 0

    fun next(n: Int): Int {
        val nNums = nums.size
        var iter = n
        while (idx < nNums && iter > nums[idx]) {
            iter -= nums[idx]
            idx += 2
        }

        if (idx >= nNums) return -1

        nums[idx] -= iter
        return nums[idx + 1]
    }
}