package com.idiotleon.leetcode.ood.lvl4.lc0224

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/basic-calculator/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 */
@Suppress(UNUSED)
class Solution0ParsingString {
    private companion object {
        private const val SIGN_PLUS = '+'
        private const val SIGN_MINUS = '-'

        private const val PAREN_OPEN = '('
        private const val PAREN_CLOSED = ')'
    }

    fun calculate(s: String): Int {
        val lenS = s.length

        var num = 0
        var ans = 0
        var sign = 1

        val stack = ArrayDeque<Int>(lenS).also {
            it.addLast(sign)
        }

        for (ch in s) {
            when (ch) {
                in '0'..'9' -> num = num * 10 + (ch - '0')
                SIGN_PLUS, SIGN_MINUS -> {
                    ans += sign * num
                    sign = stack.last() * (if (ch == SIGN_PLUS) 1 else -1)
                    num = 0
                }

                PAREN_OPEN -> stack.addLast(sign)
                PAREN_CLOSED -> stack.removeLast()

                else -> {
                }
            }
        }

        ans += sign * num
        return ans
    }
}