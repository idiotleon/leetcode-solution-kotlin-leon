/**
 * https://leetcode.com/problems/sentence-screen-fitting/
 *
 * Time Complexity:     O(`lenP`)
 * Space Complexity:    O(`lenP`)
 *
 * References:
 *  https://leetcode.com/problems/sentence-screen-fitting/discuss/90845/21ms-18-lines-Java-solution/95274
 *  https://leetcode.com/problems/sentence-screen-fitting/discuss/90845/21ms-18-lines-Java-solution/95290
 *  https://leetcode.com/problems/sentence-screen-fitting/discuss/90845/21ms-18-lines-Java-solution
 */
package com.idiotleon.leetcode.lvl4.lc0418

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    private companion object {
        private const val CH_SPACE = ' '
    }

    fun wordsTyping(sentences: Array<String>, rows: Int, cols: Int): Int {
        val padded = sentences.joinToString(CH_SPACE.toString()) + CH_SPACE
        val lenP = padded.length

        val distances = IntArray(lenP) { 0 }.also {
            for (idx in 1 until lenP) {
                it[idx] = if (padded[idx] == CH_SPACE) 1 else it[idx - 1] - 1
            }
        }

        var count = 0
        for (row in 0 until rows) {
            count += cols
            count += distances[count % lenP]
        }

        return count / lenP
    }
}