package com.idiotleon.leetcode.lvl4.lc0187.withBit

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/repeated-dna-sequences/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@Suppress(UNUSED)
class SolutionApproach0SlidingWindow1 {
    private companion object {
        // not used
        // private const val LEN = 10

        // to maintain a window of 2-bits of size 10, otherwise discarded (flip to 0)
        private const val WINDOWS_SIZE = 0xfffff

        private val decode = hashMapOf('A' to 0, 'C' to 1, 'G' to 2, 'T' to 3)
    }

    fun findRepeatedDnaSequences(s: String): List<String> {
        val lenS = s.length

        val ans = arrayListOf<String>()
        val freqs = HashMap<Int, Int>()

        var bitMask = 0
        for (idx in 0 until lenS) {
            bitMask = bitMask shl 2
            bitMask = bitMask or (decode[s[idx]] ?: 0)
            bitMask = bitMask and WINDOWS_SIZE
            if (idx < 9) continue

            freqs[bitMask] = (freqs[bitMask] ?: 0) + 1
            freqs[bitMask]?.let {
                if (it == 2) { // to only add the substring when the frequency is exactly equal to 2
                    ans.add(s.substring(idx - 9, idx + 1))
                }
            }
        }

        return ans
    }
}