package com.idiotleon.leetcode.lvl3.lc1249

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * Reference:
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/discuss/419402/JavaC%2B%2B-Stack
 */
@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val PLACEHOLDER = '#'
        private const val PAREN_OPEN = '('
        private const val PAREN_CLOSED = ')'
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun minRemoveToMakeValid(s: String): String {
        // sanity check
        if (s.isEmpty()) {
            return ""
        }

        // not used
        // val lenS = s.length
        val chs = s.toCharArray()

        val stack = ArrayDeque<Int>()

        for ((idx, ch) in chs.withIndex()) {
            when (ch) {
                PAREN_OPEN -> {
                    stack.addLast(idx)
                }

                PAREN_CLOSED -> {
                    if (stack.isEmpty()) {
                        chs[idx] = PLACEHOLDER
                    } else {
                        stack.removeLast()
                    }
                }

                else -> {

                }
            }
        }

        while (stack.isNotEmpty()) {
            chs[stack.removeLast()] = PLACEHOLDER
        }

        val builder = StringBuilder()
        for (ch in chs) {
            if (ch != PLACEHOLDER) {
                builder.append(ch)
            }
        }

        return builder.toString()
    }
}