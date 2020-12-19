/**
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 *
 * Time Complexity:     O(`nNums` + `max`)
 * Space Complexity:    O(`RANGE`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-increment-to-make-array-unique/discuss/198215/Java-O(n-%2B-m)-solution-without-sort
 */
package com.zea7ot.leetcode.lvl2.lc0945

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0CountingSort {
    private companion object {
        private const val RANGE = 4e4.toInt() + 1
    }

    fun minIncrementForUnique(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        val counts = IntArray(RANGE) { 0 }
        var minIncre = 0
        var max = 0
        for (num in nums) {
            ++counts[num]
            max = maxOf(max, num)
        }

        for (num in 0 until max) {
            if (counts[num] <= 1) continue

            val diff = counts[num] - 1
            minIncre += diff
            counts[num + 1] += diff
            counts[num] = 1
        }

        var diff = counts[max] - 1
        minIncre += (1 + diff) * diff / 2
        return minIncre
    }
}