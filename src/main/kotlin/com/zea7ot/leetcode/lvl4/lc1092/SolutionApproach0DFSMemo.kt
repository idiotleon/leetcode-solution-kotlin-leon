/**
 * https://leetcode.com/problems/shortest-common-supersequence/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/shortest-common-supersequence/discuss/317092/java-Memoization-solution
 */
package com.zea7ot.leetcode.lvl4.lc1092

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        val len1 = str1.length
        val len2 = str2.length
        val memo = Array(len1) { Array<String?>(len2) { null } }

        val common = dfs(0, str1, 0, str2, memo)
        if (common.isEmpty()) return str1 + str2

        val builder = StringBuilder()
        var idx1 = 0
        var idx2 = 0

        for (ch in common) {
            while (idx1 < len1 && str1[idx1] != ch) {
                builder.append(str1[idx1++])
            }

            while (idx2 < len2 && str2[idx2] != ch) {
                builder.append(str2[idx2++])
            }

            builder.append(ch)
            ++idx1
            ++idx2
        }

        builder.append(str1.substring(idx1)).append(str2.substring(idx2))
        return builder.toString()
    }

    private fun dfs(idx1: Int, str1: String, idx2: Int, str2: String, memo: Array<Array<String?>>): String {
        val len1 = str1.length
        val len2 = str2.length
        if (idx1 >= len1 || idx2 >= len2) return ""

        memo[idx1][idx2]?.let { return it }

        memo[idx1][idx2] = if (str1[idx1] == str2[idx2]) {
            "${str1[idx1]}${dfs(idx1 + 1, str1, idx2 + 1, str2, memo)}"

            // or equivalently
            // str1[idx1].toString() + dfs(idx1 + 1, str1, idx2 + 1, str2, memo)
        } else {
            val left = dfs(idx1 + 1, str1, idx2, str2, memo)
            val right = dfs(idx1, str1, idx2 + 1, str2, memo)

            if (left.length > right.length) left else right
        }

        // cannot avoid `!!` easily here
        return memo[idx1][idx2]!!
    }
}