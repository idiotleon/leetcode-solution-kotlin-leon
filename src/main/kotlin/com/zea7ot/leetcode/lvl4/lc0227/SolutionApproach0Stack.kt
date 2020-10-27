/**
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1) / O(`lenS`)
 */
package com.zea7ot.leetcode.lvl4.lc0227

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

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

        val stack = LinkedList<Int>()
        var num = 0
        var op = SIGN_PLUS

        for (idx in s.indices) {
            val ch = s[idx]
            if (ch in '0'..'9') num = num * 10 + (ch - '0')

            if (ch !in '0'..'9' && ch != SPACE || idx == lenS - 1) {
                when (op) {
                    SIGN_PLUS -> stack.push(num)
                    SIGN_MINUS -> stack.push(-num)
                    SIGN_MULTIPLY -> {
                        val product = num * stack.pop()
                        stack.push(product)
                    }
                    SIGN_DIVIDE -> {
                        val quotient = stack.pop() / num
                        stack.push(quotient)
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
            ans += stack.pop()
        }

        return ans
    }
}