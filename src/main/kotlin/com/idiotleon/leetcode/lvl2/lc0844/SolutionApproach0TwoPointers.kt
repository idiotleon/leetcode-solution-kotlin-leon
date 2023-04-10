/**
 * @author: Leon
 * https://leetcode.com/problems/backspace-string-compare/
 *
 * Time Complexity:     O(max(`lenS`, `lenT`))
 * Space Complexity:    O(max(`lenS`, `lenT`))
 */
package com.idiotleon.leetcode.lvl2.lc0844

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    private companion object {
        private const val ESCAPE = '#'
    }

    fun backspaceCompare(S: String, T: String): Boolean {
        // not used
        // val lenS = S.length
        // val lenT = T.length

        return parse(S) == parse(T)
    }

    private fun parse(str: String): String {
        val builder = StringBuilder()

        for (ch in str) {
            if (ch == ESCAPE) {
                if (builder.isNotEmpty()) {
                    builder.deleteCharAt(builder.length - 1)
                }
            } else builder.append(ch)
        }

        return builder.toString()
    }
}