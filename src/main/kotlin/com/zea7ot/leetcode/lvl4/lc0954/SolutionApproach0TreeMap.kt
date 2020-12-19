/**
 * https://leetcode.com/problems/array-of-doubled-pairs/
 *
 * Time Complexity:     O(`nNums` * distinct(`nNums`))
 * Space Complexity:    O(distinct(`nNums`))
 *
 * References:
 *  https://leetcode.com/problems/array-of-doubled-pairs/discuss/203183/JavaC++Python-Match-from-the-Smallest-or-Biggest-100/207414
 *  https://leetcode.com/problems/array-of-doubled-pairs/discuss/203183/JavaC%2B%2BPython-Match-from-the-Smallest-or-Biggest-100
 */
package com.zea7ot.leetcode.lvl4.lc0954

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0TreeMap {
    fun canReorderDoubled(nums: IntArray): Boolean {
        // not used
        // val nNums = nums.size

        if (nums.sum() % 3 != 0) return false

        val numToFreq = TreeMap<Int, Int>()
        for (num in nums) numToFreq[num] = 1 + (numToFreq[num] ?: 0)

        for ((num, freq) in numToFreq) {
            if (freq == 0) continue

            val expected = if (num < 0) num / 2 else num * 2
            val freqExpected = numToFreq[expected] ?: 0
            if (freqExpected < freq) return false

            numToFreq[num] = 0
            numToFreq[expected] = freqExpected - freq
        }

        return true
    }
}