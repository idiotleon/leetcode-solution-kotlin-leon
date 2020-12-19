/**
 * https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/
 *
 * Time Complexity:     O(`lenW` * (27 ^ nFingers))
 * Space Complexity:    O(`lenW` * (27 ^ nFingers))
 *
 * References:
 *  https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/discuss/477659/4+-DP-Solutions/425635
 *  https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/discuss/477659/4%2B-DP-Solutions
 */
package com.zea7ot.leetcode.lvl4.lc1320

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun minimumDistance(word: String): Int {
        val memo = Array(27) { Array(27) { Array<Int?>(300) { null } } }
        return dfs(null, null, 0, word, memo)
    }

    private fun dfs(ch1: Char?, ch2: Char?, idxCh: Int, word: String, memo: Array<Array<Array<Int?>>>): Int {
        val lenW = word.length
        if (idxCh >= lenW) return 0

        val idx1 = if (ch1 == null) 0 else ch1 - 'A' + 1
        val idx2 = if (ch2 == null) 0 else ch2 - 'A' + 1

        if (memo[idx1][idx2][idxCh] == null) {
            memo[idx1][idx2][idxCh] = minOf(
                getDistance(ch1, word[idxCh]) + dfs(word[idxCh], ch2, 1 + idxCh, word, memo),
                getDistance(ch2, word[idxCh]) + dfs(ch1, word[idxCh], 1 + idxCh, word, memo)
            )
        }

        return memo[idx1][idx2][idxCh]!!
    }

    private fun getDistance(ch1: Char?, ch2: Char?): Int {
        if (ch1 == null || ch2 == null) return 0
        val index1 = ch1 - 'A'
        val index2 = ch2 - 'A'

        val row1 = index1 / 6
        val col1 = index1 % 6
        val row2 = index2 / 6
        val col2 = index2 % 6

        return abs(row1 - row2) + abs(col1 - col2)
    }
}