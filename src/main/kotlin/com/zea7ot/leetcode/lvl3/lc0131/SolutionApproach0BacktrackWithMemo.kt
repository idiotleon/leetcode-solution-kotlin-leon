/**
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * Time Complexity:     O(`lenS` * (2 ^ `lenS`))
 * Space Complexity:    O(`lenS` ^ 2) + O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/palindrome-partitioning/discuss/41982/Java-DP-%2B-DFS-solution
 */
package com.zea7ot.leetcode.lvl3.lc0131

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BacktrackWithMemo {
    fun partition(str: String): List<List<String>> {
        val lenS = str.length

        val path = mutableListOf<String>()
        val paths = mutableListOf<List<String>>()

        val isPalindrome = Array(lenS) { BooleanArray(lenS) { false } }
        for (hi in str.indices) {
            for (lo in 0..hi) {
                if (str[lo] == str[hi] && (hi - lo <= 2 || isPalindrome[lo + 1][hi - 1])) {
                    isPalindrome[lo][hi] = true
                }
            }
        }

        backtrack(0, path, str, isPalindrome, paths)

        return paths
    }

    private fun backtrack(
        idxStart: Int,
        path: MutableList<String>,
        str: String,
        isPalindrome: Array<BooleanArray>,
        paths: MutableList<List<String>>
    ) {

        val lenS = str.length
        if (idxStart == lenS) {
            paths.add(path.toList())
            return
        }

        for (idx in idxStart until lenS) {
            if (isPalindrome[idxStart][idx]) {
                path.add(str.substring(idxStart, idx + 1))
                backtrack(idx + 1, path, str, isPalindrome, paths)
                path.removeAt(path.size - 1)
            }
        }
    }
}