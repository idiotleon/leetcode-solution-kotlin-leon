/**
 * @author: Leon
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 */
package com.idiotleon.leetcode.lvl2.lc1047

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Stack1 {
    @OptIn(ExperimentalStdlibApi::class)
    fun removeDuplicates(str: String): String {
        // not used
        // val lenS = str.length

        val stack = ArrayDeque<Char>()

        for (ch in str) {
            if (stack.isEmpty() || stack.first() != ch)
                stack.addFirst(ch)
            else
                while (stack.isNotEmpty() && stack.first() == ch) {
                    stack.removeFirst()
                }
        }

        val builder = StringBuilder()
        while (stack.isNotEmpty()) {
            builder.append(stack.removeFirst())
        }

        builder.reverse()
        return builder.toString()
    }
}