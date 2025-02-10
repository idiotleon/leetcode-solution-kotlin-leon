package com.idiotleon.leetcode.lvl1.lc3174

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/clear-digits/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 */
@Suppress(UNUSED)
class Solution0Stack1 {
    fun clearDigits(s: String): String {
        val lenS = s.length

        val stack = ArrayDeque<Char>(lenS)
        for (ch in s) {
            if (ch in '0'..'9') {
                if (stack.isNotEmpty()) {
                    stack.removeLast()
                }
            } else {
                stack.addLast(ch)
            }
        }

        val builder = StringBuilder()
        while (stack.isNotEmpty()) {
            builder.append(stack.removeLast())
        }
        builder.reverse()
        return builder.toString()
    }
}