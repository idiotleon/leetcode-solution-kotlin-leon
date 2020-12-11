/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl1.lc1614

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val OPEN_PAREN = '('
        private const val CLOSED_PAREN = ')'
    }

    fun maxDepth(s: String): Int {
        // not used
        // val lenS = s.length

        var deepest = 0

        var stack = 0

        for (ch in s) {
            when (ch) {
                OPEN_PAREN -> ++stack
                CLOSED_PAREN -> --stack
                else -> {
                }
            }

            deepest = maxOf(deepest, stack)
        }

        return deepest
    }
}