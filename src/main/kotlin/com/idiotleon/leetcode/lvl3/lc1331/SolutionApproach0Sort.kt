package com.idiotleon.leetcode.lvl3.lc1331

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/rank-transform-of-an-array/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/rank-transform-of-an-array/discuss/489753/JavaC%2B%2BPython-HashMap
 */
@Suppress(UNUSED)
class SolutionApproach0Sort {
    fun arrayRankTransform(nums: IntArray): IntArray {
        val nNums = nums.size

        val sorted = nums.sorted().toIntArray()

        val numToRank = HashMap<Int, Int>(nNums)
        for (num in sorted) {
            if (!numToRank.containsKey(num)) {
                numToRank[num] = 1 + numToRank.size
            }
        }

        for (idx in nums.indices) {
            sorted[idx] = numToRank[nums[idx]]!!
        }

        return sorted
    }
}