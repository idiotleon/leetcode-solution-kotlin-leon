package com.an7one.leetcode.lvl4.lc0187.withBit

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/repeated-dna-sequences/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 *
 * References:
 *  https://leetcode.com/problems/repeated-dna-sequences/discuss/53867/Clean-Java-solution-(hashmap-+-bits-manipulation)/201065
 *  https://leetcode.com/problems/repeated-dna-sequences/discuss/53867/Clean-Java-solution-(hashmap-+-bits-manipulation)/55192
 *  https://leetcode.com/problems/repeated-dna-sequences/discuss/53867/Clean-Java-solution-(hashmap-%2B-bits-manipulation)
 */
@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    private companion object {
        private const val LEN = 10
        private val decodeMap = hashMapOf('A' to 0, 'C' to 1, 'G' to 2, 'T' to 3)
    }

    fun findRepeatedDnaSequences(s: String): List<String> {
        val ans = arrayListOf<String>()

        val lenS = s.length
        if (lenS < LEN + 1) return ans

        val seenOnce = HashSet<Int>()
        val seenTwice = HashSet<Int>()

        var bitMask = 0
        // to initialize `bitMask`
        for (idx in 0 until LEN) {
            bitMask = bitMask shl 2
            bitMask = bitMask or (decodeMap[s[idx]] ?: 0)
        }
        seenOnce.add(bitMask)

        for (idx in 1 until lenS - LEN + 1) {
            // to trim the first 2bits
            bitMask = bitMask and (3 shl 18).inv()
            // to left shift 2 bits
            bitMask = bitMask shl 2
            // to get the new bit mask
            bitMask = bitMask or (decodeMap[s[idx + LEN - 1]] ?: 0)

            if (!seenOnce.add(bitMask) && seenTwice.add(bitMask)) {
                ans.add(s.substring(idx, idx + LEN))
            }
        }

        return ans
    }
}