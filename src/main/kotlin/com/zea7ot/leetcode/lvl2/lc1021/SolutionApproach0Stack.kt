/**
 * @author: Leon
 * https://leetcode.com/problems/remove-outermost-parentheses/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/remove-outermost-parentheses/discuss/270022/JavaC%2B%2BPython-Count-Opened-Parenthesis
 */
package com.zea7ot.leetcode.lvl2.lc1021

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val OPEN_PAREN = '('
        private const val CLOSED_PAREN = ')'
    }

    fun removeOuterParentheses(S: String): String {
        var stack = 0

        val builder = StringBuilder()

        for (ch in S) {
            when (ch) {
                OPEN_PAREN -> {
                    if (stack > 0) {
                        builder.append(OPEN_PAREN)
                    }
                    ++stack
                }
                CLOSED_PAREN -> {
                    --stack
                    if (stack > 0) {
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