/**
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-increment-to-make-array-unique/discuss/197687/JavaC%2B%2BPython-Straight-Forward
 */
package com.zea7ot.leetcode.lvl2.lc0945

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Sort {
    fun minIncrementForUnique(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        nums.sort()
        var minIncre = 0
        var expected = 0

        for (num in nums) {
            minIncre += maxOf(expected - num, 0)
            expected = 1 + maxOf(num, expected)
        }

        return minIncre
    }
}