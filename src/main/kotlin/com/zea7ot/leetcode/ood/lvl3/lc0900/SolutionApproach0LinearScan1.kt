/**
 * https://leetcode.com/problems/rle-iterator/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/rle-iterator/discuss/168294/Java-Straightforward-Solution-O(n)-time-O(1)-space/255436
 *  https://leetcode.com/problems/rle-iterator/discuss/168294/Java-Straightforward-Solution-O(n)-time-O(1)-space
 */
package com.zea7ot.leetcode.ood.lvl3.lc0900

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1(private val nums: IntArray) {
    private var idx = 0
    private var pos = nums[0]

    fun next(n: Int): Int {
        val totalNums = nums.size
        var iter = n
        while (idx < totalNums && iter > 0) {
            if (iter > pos) {
                idx += 2
                iter -= pos

                if (idx < totalNums) {
                    pos = nums[idx]
                }
            } else {
                pos -= iter
                iter = 0
            }
        }

        if (idx >= totalNums) return -1
        return nums[1 + idx]
    }
}