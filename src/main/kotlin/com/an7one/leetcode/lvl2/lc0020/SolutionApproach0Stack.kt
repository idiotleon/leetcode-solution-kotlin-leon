package com.an7one.leetcode.lvl2.lc0020

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 */
@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val PAREN_OPEN1 = '('
        private const val PAREN_OPEN2 = '['
        private const val PAREN_OPEN3 = '{'
        private const val PAREN_CLOSED1 = ')'
        private const val PAREN_CLOSED2 = ']'
        private const val PAREN_CLOSED3 = '}'
    }

    fun isValid(str: String): Boolean {
        // not used
        // val lenS = str.length

        val stack = ArrayDeque<Char>()

        for (ch in str) {
            when (ch) {
                PAREN_OPEN1 -> stack.addLast(PAREN_CLOSED1)
                PAREN_OPEN2 -> stack.addLast(PAREN_CLOSED2)
                PAREN_OPEN3 -> stack.addLast(PAREN_CLOSED3)
                else -> {
                    if (stack.isEmpty())
                        return false

                    if (stack.removeLast() != ch)
                        return false
                }
            }
        }

        if (stack.isNotEmpty())
            return false

        return true
    }
}