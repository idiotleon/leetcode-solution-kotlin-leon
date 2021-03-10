/**
 * @author: Leon
 * https://leetcode.com/problems/remove-outermost-parentheses/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS` / 2) ~ O(`lenS`)
 */
package com.an7one.leetcode.lvl2.lc1021

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack1 {
    private companion object {
        private const val OPEN_PAREN = '('
        private const val CLOSED_PAREN = ')'
    }

    fun removeOuterParentheses(S: String): String {
        // not used
        // val lenS = S.length

        val stack = LinkedList<Char>()

        val builder = StringBuilder()

        for (ch in S) {
            when (ch) {
                OPEN_PAREN -> {
                    if (stack.isNotEmpty()) {
                        builder.append(OPEN_PAREN)
                    }
                    stack.push(OPEN_PAREN)
                }
                CLOSED_PAREN -> {
                    stack.pop()
                    if (stack.isNotEmpty()) {
                        builder.append(CLOSED_PAREN)
                    }
                }
                else -> {
                }
            }
        }

        return builder.toString()
    }
}