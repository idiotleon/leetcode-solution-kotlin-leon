/**
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * Time Complexity:     O(`lenS` * (2 ^ `lenS`))
 * Space Complexity:    O(`lenS` ^ 2) + O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/palindrome-partitioning/discuss/41982/Java-DP-+-DFS-solution/387904
 */
package com.zea7ot.leetcode.lvl3.lc0131

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BacktrackWithMemo1 {
    fun partition(str: String): List<List<String>> {
        val lenS = str.length

        val paths = ArrayList<List<String>>()
        val path = ArrayList<String>()
        val memo = Array(lenS) { BooleanArray(lenS) { false } }
        backtrack(0, path, str, memo, paths)
        return paths
    }

    private fun backtrack(startIdx: Int,
                          path: ArrayList<String>,
                          str: String,
                          memo: Array<BooleanArray>,
                          paths: ArrayList<List<String>>) {

        val lenS = str.length
        if (startIdx >= lenS) {
            paths.add(path.toList())
        }

        for (idx in startIdx until lenS) {
            if (str[startIdx] != str[idx]) continue
            if (idx - 1 > startIdx + 1 && !memo[startIdx + 1][idx - 1]) continue

            memo[startIdx][idx] = true
            path.add(str.substring(startIdx, idx + 1))
            backtrack(idx + 1, path, str, memo, paths)
            path.removeAt(path.size - 1)
        }
    }
}