/**
 * https://leetcode.com/problems/rank-transform-of-an-array/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/rank-transform-of-an-array/discuss/489753/JavaC%2B%2BPython-HashMap
 */
package com.zea7ot.leetcode.lvl3.lc1331

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Sort {
    fun arrayRankTransform(nums: IntArray): IntArray {
        // not used
        // val nNums = nums.size

        val sorted = nums.sorted().toIntArray()

        val ranks = HashMap<Int, Int>()
        for (num in sorted) {
            if (!ranks.containsKey(num)) {
                ranks[num] = ranks.size + 1
            }
        }

        for (idx in nums.indices) {
            sorted[idx] = ranks[nums[idx]]!!
        }

        return sorted
    }
}