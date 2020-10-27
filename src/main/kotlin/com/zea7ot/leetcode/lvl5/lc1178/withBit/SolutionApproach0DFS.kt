/**
 * https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/
 *
 * Time Complexity:     O(`totalWords` * (2 ^ 7) + `totalPuzzles` * lenW)
 *  lenW, the average length of the words
 *
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/discuss/372385/Java-Bit-manipulation-%2B-Map-Solution-90ms
 */
package com.zea7ot.leetcode.lvl5.lc1178.withBit

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFS {
    fun findNumOfValidWords(words: Array<String>,
                            puzzles: Array<String>): List<Int> {

        // not used
        // val totalWords = words.size
        // val totalPuzzles = puzzles.size

        val freqs = HashMap<Int, Int>()
        for (word in words) {
            var bitMask = 0
            for (ch in word) {
                bitMask = bitMask or (1 shl (ch - 'a'))
            }
            freqs[bitMask] = 1 + (freqs[bitMask] ?: 0)
        }

        val ans = ArrayList<Int>()

        for (puzzle in puzzles) {
            var bitMask = 0
            for (ch in puzzle) {
                bitMask = bitMask or (1 shl (ch - 'a'))
            }

            var count = 0
            var bitMaskSubstring = bitMask
            val firstLetter = 1 shl (puzzle[0] - 'a')

            while (bitMaskSubstring > 0) {
                if ((bitMaskSubstring and firstLetter) == firstLetter) {
                    count += (freqs[bitMaskSubstring] ?: 0)
                }

                // to get the next substrings,
                // ultimately to get all the substrings
                bitMaskSubstring = (bitMaskSubstring - 1) and bitMask
            }

            ans.add(count)
        }

        return ans
    }
}