package com.idiotleon.leetcode.lvl4.lc0187

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/repeated-dna-sequences/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/repeated-dna-sequences/discuss/53867/Clean-Java-solution-(hashmap-%2B-bits-manipulation)
 */
@Suppress(UNUSED)
class SolutionApproach1HashMap1 {
    private companion object {
        private const val LEN = 10
        private val decode = hashMapOf('A' to 0, 'C' to 1, 'G' to 2, 'T' to 3)
    }

    fun findRepeatedDnaSequences(s: String): List<String> {
        val lenS = s.length

        val ans = arrayListOf<String>()

        val freqs = HashMap<Int, Int>()


        for (lo in 0..lenS - LEN) {
            var bitMask = 0

            for (hi in lo until lo + LEN) {
                bitMask = bitMask shl 2
                bitMask = bitMask or (decode[s[hi]] ?: 0)
            }

            freqs[bitMask] = (freqs[bitMask] ?: 0) + 1
            freqs[bitMask]?.let {
                if (it == 2) { // to only add the substring when the frequency is exactly equal to 2
                    ans.add(s.substring(lo, lo + LEN))
                }
            }
        }

        return ans
    }
}