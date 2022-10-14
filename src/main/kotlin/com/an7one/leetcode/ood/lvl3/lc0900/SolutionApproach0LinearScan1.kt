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
 * https://leetcode.com/problems/rle-iterator/discuss/168294/Java-Straightforward-Solution-O(n)-time-O(1)-space/255436
 * https://leetcode.com/problems/rle-iterator/discuss/168294/Java-Straightforward-Solution-O(n)-time-O(1)-space
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan1(private val nums: IntArray) {
    private var idx = 0
    private var pos = nums[0]

    fun next(n: Int): Int {
        val nNums = nums.size
        var iter = n
        while (idx < nNums && iter > 0) {
            if (iter > pos) {
                idx += 2
                iter -= pos

                if (idx < nNums) {
                    pos = nums[idx]
                }
            } else {
                pos -= iter
                iter = 0
            }
        }

        if (idx >= nNums) return -1
        return nums[1 + idx]
    }
}