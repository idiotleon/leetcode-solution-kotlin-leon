package com.idiotleon.leetcode.lvl4.lc0227

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.collections.ArrayDeque

/**
 * @author: Leon
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1) / O(`lenS`)
 */
@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val SPACE = ' '
        private const val SIGN_PLUS = '+'
        private const val SIGN_MINUS = '-'
        private const val SIGN_MULTIPLY = '*'
        private const val SIGN_DIVIDE = '/'
    }

    fun calculate(s: String): Int {
        val lenS = s.length

        val stack = ArrayDeque<Int>()
        var num = 0
        var op = SIGN_PLUS

        for ((idx, ch) in s.withIndex()) {
            if (ch in '0'..'9') num = num * 10 + (ch - '0')

            if (ch !in '0'..'9' && ch != SPACE || idx == lenS - 1) {
                when (op) {
                    SIGN_PLUS -> stack.addLast(num)
                    SIGN_MINUS -> stack.addLast(-num)
                    SIGN_MULTIPLY -> {
                        val product = num * stack.removeLast()
                        stack.addLast(product)
                    }
                    SIGN_DIVIDE -> {
                        val quotient = stack.removeLast() / num
                        stack.addLast(quotient)
                    }
                    else -> {
                    }
                }

                op = ch
                num = 0
            }
        }

        var ans = 0
        while (stack.isNotEmpty()) {
            ans += stack.removeLast()
        }

        return ans
    }
}