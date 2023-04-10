/**
 * https://leetcode.com/problems/array-of-doubled-pairs/
 *
 * Time Complexity:     O(`nNums` * distinct(`nNums`))
 * Space Complexity:    O(distinct(`nNums`))
 *
 * References:
 *  https://leetcode.com/problems/array-of-doubled-pairs/discuss/203183/JavaC%2B%2BPython-Match-from-the-Smallest-or-Biggest-100
 */
package com.idiotleon.leetcode.lvl4.lc0954

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0TreeMap1 {
    fun canReorderDoubled(nums: IntArray): Boolean {
        // not used
        // val nNums = nums.size

        if (nums.sum() % 3 != 0) return false

        val freqs = TreeMap<Int, Int>()
        for (num in nums) freqs[num] = 1 + (freqs[num] ?: 0)

        for ((num, freq) in freqs) {
            if (freq == 0) continue

            val expected = if (num < 0) num / 2 else num * 2
            if (num < 0 && num % 2 != 0 || freq > (freqs[expected] ?: 0)) return false

            freqs[expected] = (freqs[expected] ?: 0) - freq
        }

        return true
    }
}