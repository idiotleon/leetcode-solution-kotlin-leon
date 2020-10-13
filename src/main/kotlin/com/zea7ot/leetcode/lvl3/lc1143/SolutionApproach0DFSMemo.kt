/**
 * @author: Leon
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * Time Complexity:     O(`len1` * `len2`)
 * Space Complexity:    O(`len1` * `len2`)
 *
 * References:
 *  https://leetcode.com/problems/longest-common-subsequence/discuss/398711/ALL-4-ways-Recursion-greater-Top-down-greaterBottom-Up-greater-Efficient-Solution-O(N)-including-VIDEO-TUTORIAL
 *  https://leetcode.com/problems/longest-common-subsequence/discuss/348884/C%2B%2B-with-picture-O(nm)
 *  https://leetcode.com/problems/longest-common-subsequence/discuss/841563/Java-Recursion-greater-memo-greater-dp
 */
package com.zea7ot.leetcode.lvl3.lc1143

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val len1 = text1.length
        val len2 = text2.length

        val memo = Array(len1) { Array<Int?>(len2) { null } }
        return dfs(0, text1, 0, text2, memo)
    }

    private fun dfs(idx1: Int, str1: String,
                    idx2: Int, str2: String,
                    memo: Array<Array<Int?>>): Int {
        val len1 = str1.length
        val len2 = str2.length

        if (idx1 >= len1 || idx2 >= len2) return 0

        memo[idx1][idx2]?.let { return it }

        val longest = if (str1[idx1] == str2[idx2]) {
            dfs(idx1 + 1, str1, idx2 + 1, str2, memo) + 1
        } else {
            maxOf(dfs(idx1 + 1, str1, idx2, str2, memo), dfs(idx1, str1, idx2 + 1, str2, memo))
        }

        memo[idx1][idx2] = longest
        return longest
    }
}