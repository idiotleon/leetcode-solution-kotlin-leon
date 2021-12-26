/**
 * https://leetcode.com/problems/basic-calculator/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 */
package com.an7one.leetcode.lvl5.lc0224

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.collections.ArrayDeque

@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val SPACE = ' '
        private const val SIGN_PLUS = '+'
        private const val SIGN_MINUS = '-'
        private const val SIGN_MULTIPLY = '*'
        private const val SIGN_DIVIDE = '/'

        private const val OPEN_PAREN = '('
        private const val CLOSED_PAREN = ')'
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun calculate(s: String): Int {
        // not used
        // val lenS = s.length
        var num = 0
        var ans = 0
        var sign = 1

        val stack = ArrayDeque<Int>()
        stack.addLast(sign)

        for (ch in s) {
            when (ch) {
                in '0'..'9' -> num = num * 10 + (ch - '0')
                SIGN_PLUS, SIGN_MINUS -> {
                    ans += sign * num
                    sign = stack.last() * (if (ch == SIGN_PLUS) 1 else -1)
                    num = 0
                }
                OPEN_PAREN -> stack.addLast(sign)
                CLOSED_PAREN -> stack.removeLast()
                else -> {
                }
            }
        }

        ans += sign * num
        return ans
    }
}