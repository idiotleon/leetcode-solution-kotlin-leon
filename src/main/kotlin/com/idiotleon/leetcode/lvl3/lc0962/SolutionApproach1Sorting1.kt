package com.idiotleon.leetcode.lvl3.lc0962

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-width-ramp/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/maximum-width-ramp/discuss/208348/JavaC%2B%2BPython-O(N)-Using-Stack
 */
@Suppress(UNUSED)
class SolutionApproach1Sorting1 {
    fun maxWidthRamp(nums: IntArray): Int {
        val nNums = nums.size

        // pairs of value(s)-index(es)
        val pairs = Array(nNums) { idx -> intArrayOf(nums[idx], idx) }
        // to sort by values
        pairs.sortBy { it[0] }

        var shortest = nNums
        var widest = 0

        for (pair in pairs) {
            widest = maxOf(widest, pair[1] - shortest)
            shortest = minOf(shortest, pair[1])
        }

        return widest
    }
}