/**
 * https://leetcode.com/problems/sentence-screen-fitting/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/sentence-screen-fitting/discuss/90845/21ms-18-lines-Java-solution/95290
 *  https://leetcode.com/problems/sentence-screen-fitting/discuss/90845/21ms-18-lines-Java-solution
 */
package com.zea7ot.leetcode.lvl4.lc0418

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    private companion object {
        private const val SPACE = ' '
    }

    fun wordsTyping(sentence: Array<String>, rows: Int, cols: Int): Int {
        val padded = sentence.joinToString(SPACE.toString()) + SPACE
        val lenS = padded.length
        var count = 0

        val map = IntArray(lenS) { 0 }.also {
            for (i in 1 until lenS) {
                it[i] = if (padded[i] == SPACE) 1 else it[i - 1] - 1
            }
        }

        for (row in 0 until rows) {
            count += cols
            count += map[count % lenS]
        }

        return count / lenS
    }
}