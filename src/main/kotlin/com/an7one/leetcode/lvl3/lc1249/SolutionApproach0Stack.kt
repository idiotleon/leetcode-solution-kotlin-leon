/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/discuss/419402/JavaC%2B%2B-Stack
 */
package com.an7one.leetcode.lvl3.lc1249

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val PLACE_HOLDER = '#'
        private const val PAREN_OPEN = '('
        private const val PAREN_CLOSED = ')'
    }

    fun minRemoveToMakeValid(str: String): String {
        // sanity check
        if (str.isEmpty()) return ""

        // not used
        // val lenS = str.length
        val chs = str.toCharArray()

        val stack = LinkedList<Int>()

        for (idx in str.indices) {
            when (chs[idx]) {
                PAREN_OPEN -> stack.push(idx)
                PAREN_CLOSED -> {
                    if (stack.isEmpty())
                        chs[idx] = PLACE_HOLDER
                    else
                        stack.pop()
                }
                else -> {
                }
            }
        }

        while (stack.isNotEmpty())
            chs[stack.pop()] = PLACE_HOLDER

        val builder = StringBuilder()
        for (ch in chs)
            if (ch != PLACE_HOLDER)
                builder.append(ch)

        return builder.toString()
    }
}