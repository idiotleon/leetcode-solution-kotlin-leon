/**
 * https://leetcode.com/problems/mini-parser/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/mini-parser/discuss/86066/An-Java-Iterative-Solution/91186
 *  https://leetcode.com/problems/mini-parser/discuss/86066/An-Java-Iterative-Solution
 */
package com.idiotleon.leetcode.ood.lvl2.lc0385

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val OPEN_PAREN = '['
        private const val CLOSED_PAREN = ']'
        private const val COMMA = ','
    }

    fun deserialize(str: String): FakeNestedInteger {
        val lenS = str.length

        if (!str.startsWith(OPEN_PAREN)) return FakeNestedInteger(str.toInt())

        val ans = FakeNestedInteger()
        val stack = LinkedList<FakeNestedInteger>().also { it.push(ans) }
        var start = 1

        for (idx in 1 until lenS) {
            when (val ch = str[idx]) {
                OPEN_PAREN -> {
                    val ni = FakeNestedInteger()
                    stack.peek().add(ni)
                    stack.push(ni)
                    start = idx + 1
                }

                CLOSED_PAREN, COMMA -> {
                    if (idx > start) {
                        val value = str.substring(start, idx).toInt()
                        stack.peek().add(FakeNestedInteger(value))
                    }

                    start = idx + 1
                    if (ch == CLOSED_PAREN) stack.pop()
                }

                else -> {

                }
            }
        }

        return ans
    }
}