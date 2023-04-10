/**
 * this solution is NOT yet correct
 * https://leetcode.com/problems/array-of-doubled-pairs/
 *
 * Time Complexity:     O(`OFFSET`)
 * Space Complexity:    O(`OFFSET`)
 *
 * References:
 *  https://leetcode.com/problems/array-of-doubled-pairs/discuss/203191/JAVA-17ms-O(200000)-without-Sorting-but-with-Explanation
 */
package com.idiotleon.leetcode.lvl4.lc0954

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    private companion object {
        private const val OFFSET = 1e5.toInt()
    }

    fun canReorderDoubled(nums: IntArray): Boolean {
        if (nums.sum() % 3 != 0) return false

        val freqs = IntArray(OFFSET * 2)
        for (num in nums) ++freqs[num + OFFSET]

        if (freqs[0] % 2 == 1)
            return false

        for (idx in freqs.indices) {
            if (freqs[idx] == 0) continue

            val numCur = idx - OFFSET
            // the expected `num`
            val numExp = if (numCur < 0) numCur / 2 else numCur * 2

            val freqCur = freqs[idx]
            val freqExp = freqs[numExp + OFFSET]

            if (freqExp < freqCur)
                return false

            freqs[numExp + OFFSET] = freqExp - freqCur
        }

        return true
    }
}