/**
 * https://leetcode.com/problems/number-of-wonderful-substrings/
 *
 * Time Complexity:     O(10 * `lenW`) ~ O(`lenW`)
 * Space Complexity:    O(1024) ~ O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/number-of-wonderful-substrings/discuss/1299552/JavaC%2B%2BPython-Bit-Mask-%2B-Prefix
 *  https://leetcode.com/problems/number-of-wonderful-substrings/discuss/1299523/C%2B%2B-Bit-Vector-%2B-Prefix-Parities-(Similar-to-Prefix-Sums)
 */
package com.an7one.leetcode.lvl4.lc1915.withBit

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0D0Dimen {
    fun wonderfulSubstrings(word: String): Long {
        // not used
        // val lenW = word.length

        val freqs = LongArray(1024) { 0L }.also {
            it[0] = 1L
        }

        var count = 0L
        var bitMask = 0

        for (ch in word) {
            val idxCh = ch - 'a'
            bitMask = bitMask xor (1 shl idxCh)
            count += freqs[bitMask]
            ++freqs[bitMask]
            for (idx in 0 until 10) {
                count += freqs[bitMask xor (1 shl idx)]
            }
        }

        return count
    }
}