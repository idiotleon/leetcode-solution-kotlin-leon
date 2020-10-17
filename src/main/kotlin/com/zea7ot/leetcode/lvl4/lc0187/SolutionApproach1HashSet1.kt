package com.zea7ot.leetcode.lvl4.lc0187

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach1HashSet1 {
    private companion object {
        private const val LEN = 10
    }

    fun findRepeatedDnaSequences(s: String): List<String> {
        val lenS = s.length

        val ans = arrayListOf<String>()

        val seen = HashSet<Int>()
        val seenTwice = HashSet<Int>()

        val map = IntArray(26) { 0 }
        map['A' - 'A'] = 0
        map['C' - 'A'] = 1
        map['G' - 'A'] = 2
        map['T' - 'A'] = 3

        for (lo in 0..lenS - LEN) {
            var bitMask = 0

            for (hi in lo until lo + LEN) {
                bitMask = bitMask shl 2
                bitMask = bitMask or map[s[hi] - 'A']
            }

            if (!seen.add(bitMask) && seenTwice.add(bitMask)) {
                ans.add(s.substring(lo, lo + LEN))
            }
        }

        return ans
    }
}