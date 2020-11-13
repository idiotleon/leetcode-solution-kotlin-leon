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

        val paths = mutableListOf<List<String>>()
        val path = mutableListOf<String>()
        val memo = Array(lenS) { BooleanArray(lenS) { false } }
        backtrack(0, path, str, memo, paths)

        return paths
    }

    private fun backtrack(idxStart: Int,
                          path: MutableList<String>,
                          str: String,
                          memo: Array<BooleanArray>,
                          paths: MutableList<List<String>>) {

        val lenS = str.length
        if (idxStart >= lenS) {
            paths.add(path.toList())
        }

        for (idx in idxStart until lenS) {
            if (str[idxStart] != str[idx]) continue
            if (idx - 1 > idxStart + 1 && !memo[idxStart + 1][idx - 1]) continue

            memo[idxStart][idx] = true
            path.add(str.substring(idxStart, idx + 1))
            backtrack(idx + 1, path, str, memo, paths)
            path.removeAt(path.size - 1)
        }
    }
}