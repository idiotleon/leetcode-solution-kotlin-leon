package com.idiotleon.leetcode.lvl5.lc0772

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.collections.ArrayDeque

/**
 * @author: LEon
 * https://leetcode.com/problems/basic-calculator-iii/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`) + O(NUM('(')) ~ O(`lenS`)
 *
 * Reference:
 * https://leetcode.com/problems/basic-calculator-iii/discuss/152092/O(n)-Java-Recursive-Simple-Solution/227715
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private const val PAREN_OPEN = '('
        private const val PAREN_CLOSED = ')'
        private const val SPACE = ' '

        private const val SIGN_PLUS = '+'
        private const val SIGN_MINUS = '-'
        private const val SIGN_MULTIPLY = '*'
        private const val SIGN_DIVIDE = '/'
    }

    fun calculate(s: String): Int {
        // not used
        // val lenS = s.length

        val tokens = ArrayDeque<Char>()
        for (ch in s) {
            if (ch != SPACE) tokens.addLast(ch)
        }
        tokens.addLast(SIGN_PLUS)

        return dfs(tokens)
    }

    private fun dfs(tokens: ArrayDeque<Char>): Int {
        var op = SIGN_PLUS
        var num = 0
        var sum = 0
        var prev = 0

        loop@ while (tokens.isNotEmpty()) {
            when (val ch = tokens.removeFirst()) {
                in '0'..'9' -> num = num * 10 + (ch - '0')
                PAREN_OPEN -> num = dfs(tokens)
                else -> {
                    when (op) {
                        SIGN_PLUS -> {
                            sum += prev
                            prev = num
                        }

                        SIGN_MINUS -> {
                            sum += prev
                            prev = -num
                        }

                        SIGN_MULTIPLY -> {
                            prev *= num
                        }

                        SIGN_DIVIDE -> {
                            prev /= num
                        }

                        else -> {
                        }
                    }

                    if (ch == PAREN_CLOSED) break@loop

                    op = ch
                    num = 0
                }
            }
        }

        return sum + prev
    }
}