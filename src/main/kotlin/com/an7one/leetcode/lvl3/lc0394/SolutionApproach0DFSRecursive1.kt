/**
 * https://leetcode.com/problems/decode-string/
 *
 * Time Complexity:     O(`lenS`) + O(max digit of `s`)
 * Space Complexity:    O(`lenS`) + O(max digit of `s`)
 *
 * References:
 *  https://leetcode.com/problems/decode-string/discuss/210284/Java-Recursive
 */
package com.an7one.leetcode.lvl3.lc0394

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive1 {
    private companion object {
        private const val OPEN_SQUARE_BRACKET = '['
        private const val CLOSED_SQUARE_BRACKET = ']'
    }

    fun decodeString(s: String): String {
        // not used
        // val lenS = s.length

        return dfs(intArrayOf(0), s)
    }

    private fun dfs(idx: IntArray, str: String): String {
        val lenS = str.length
        val builder = StringBuilder()
        var repCnt = 0

        loop@ while (idx[0] < lenS) {
            when (val ch = str[idx[0]]) {
                in '0'..'9' -> repCnt = repCnt * 10 + (ch - '0')
                OPEN_SQUARE_BRACKET -> {
                    ++idx[0]
                    val sub = dfs(idx, str)
                    builder.append(sub.repeat(repCnt))
                    repCnt = 0
                }
                CLOSED_SQUARE_BRACKET -> break@loop
                else -> builder.append(ch)
            }

            ++idx[0]
        }

        return builder.toString()
    }
}