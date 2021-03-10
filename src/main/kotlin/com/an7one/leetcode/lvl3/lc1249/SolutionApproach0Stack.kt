/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 *
 * References:
 *  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/discuss/419402/JavaC%2B%2B-Stack
 */
package com.an7one.leetcode.lvl3.lc1249

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack {
    fun minRemoveToMakeValid(str: String): String {
        // sanity check
        if (str.isEmpty()) return ""

        val lenS = str.length
        val chs = str.toCharArray()

        val placeHolder = '*'
        val openParen = '('
        val closedParen = ')'

        val stack = LinkedList<Int>()

        for (i in 0 until lenS) {
            when (chs[i]) {
                openParen -> stack.push(i)
                closedParen -> {
                    if (stack.isEmpty())
                        chs[i] = placeHolder
                    else
                        stack.pop()
                }
                else -> {
                }
            }
        }

        while (!stack.isEmpty())
            chs[stack.pop()] = placeHolder

        val builder = StringBuilder()
        for (ch in chs)
            if (ch != placeHolder)
                builder.append(ch)

        return builder.toString()
    }
}