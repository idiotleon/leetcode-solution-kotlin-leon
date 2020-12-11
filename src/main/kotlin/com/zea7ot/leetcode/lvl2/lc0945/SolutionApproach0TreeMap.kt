/**
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 *
 * Time Complexity:     O(`nNums` * distinct(`nums`))
 * Space Complexity:    O(distinct(`nums`))
 *
 * References:
 *  https://leetcode.com/problems/minimum-increment-to-make-array-unique/discuss/197687/JavaC%2B%2BPython-Straight-Forward
 */
package com.zea7ot.leetcode.lvl2.lc0945

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0TreeMap {
    fun minIncrementForUnique(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        val freqs = TreeMap<Int, Int>()
        for (num in nums) {
            freqs[num] = 1 + (freqs[num] ?: 0)
        }

        var minIncre = 0
        var expected = 0

        for ((num, freq) in freqs) {
            minIncre += freq * maxOf(expected - num, 0) + freq * (freq - 1) / 2
            expected = maxOf(expected, num) + freq
        }

        return minIncre
    }
}