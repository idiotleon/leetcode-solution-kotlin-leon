/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/generate-parentheses/discuss/10127/an-iterative-method/963942
 */
package com.an7one.leetcode.lvl2.lc0022

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach1DP1Dimen {
    private companion object {
        private const val PAREN_OPEN = '('
        private const val PAREN_CLOSED = ')'
    }

    fun generateParenthesis(n: Int): List<String> {
        val dp = mutableListOf<List<String>>().also {
            it.add(listOf(""))
        }

        for (hi in 1..n) {
            val list = LinkedList<String>()

            for (lo in 0 until hi) {
                for (firstSeg in dp[lo]) {
                    for (secSeg in dp[hi - 1 - lo]) {
                        list.add(PAREN_OPEN + firstSeg + PAREN_CLOSED + secSeg)
                    }
                }
            }

            dp.add(list)
        }

        return dp.last()
    }
}