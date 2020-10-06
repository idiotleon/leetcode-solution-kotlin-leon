/**
 * https://leetcode.com/problems/maximum-distance-in-arrays/
 *
 * Time Complexity:     O(`NR`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/maximum-distance-in-arrays/discuss/104613/Java-Solution-Min-and-Max
 */
package com.zea7ot.leetcode.lvl3.lc0624

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun maxDistance(arrays: List<List<Int>>): Int {
        // sanity check
        if (arrays.isEmpty()) return 0

        val sizeRows = arrays.size
        var min = arrays[0][0]
        var max = arrays[0][arrays[0].size - 1]

        var longest = Int.MIN_VALUE

        for (i in 1 until sizeRows) {
            val sizeCols = arrays[i].size

            longest = maxOf(longest, arrays[i][sizeCols - 1] - min)
            longest = maxOf(longest, max - arrays[i][0])

            max = maxOf(max, arrays[i][sizeCols - 1])
            min = minOf(min, arrays[i][0])
        }

        return longest
    }
}