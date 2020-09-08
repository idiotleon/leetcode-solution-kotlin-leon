/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 *
 * References:
 *  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/discuss/419402/JavaC%2B%2B-Stack
 */
package com.zea7ot.lc.lvl3.lc1249

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Stack {
    @ExperimentalStdlibApi
    fun minRemoveToMakeValid(s: String): String {
        // sanity check
        if (s.isEmpty()) return ""

        val len = s.length
        val chs = s.toCharArray()

        val placeHolder = '*'
        val openParen = '('
        val closedParen = ')'

        val stack = ArrayDeque<Int>()

        for (i in 0 until len) {
            when (chs[i]) {
                openParen -> stack.addFirst(i)
                closedParen -> {
                    if (stack.isEmpty())
                        chs[i] = placeHolder
                    else
                        stack.removeFirst();
                }
                else -> {
                }
            }
        }

        while (!stack.isEmpty())
            chs[stack.removeFirst()] = placeHolder

        val builder = StringBuilder()
        for (ch in chs)
            if (ch != placeHolder)
                builder.append(ch)

        return builder.toString()
    }
}