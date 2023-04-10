package com.idiotleon.leetcode.lvl4.lc1562

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/find-latest-group-of-size-m/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/find-latest-group-of-size-m/discuss/806942/JAVA-Using-Tree-Set
 */
@Suppress(UNUSED)
class SolutionApproach1TreeSet {
    fun findLatestStep(nums: IntArray, m: Int): Int {
        val nNums = nums.size
        if (nNums == m) return nNums

        val walls = TreeSet<Int>().also {
            it.add(0)
            it.add(nNums + 1)
        }

        for (idx in nNums - 1 downTo 0) {
            val lo = walls.floor(nums[idx])!!
            val hi = walls.ceiling(nums[idx])!!

            if (nums[idx] - lo - 1 == m || hi - nums[idx] - 1 == m) return idx
            walls.add(nums[idx])
        }

        return -1
    }
}