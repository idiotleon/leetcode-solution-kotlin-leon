package com.idiotleon.leetcode.lvl2.lc1221

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0Stack1 {
    class Solution {
        fun balancedStringSplit(s: String): Int {
            val lenS = s.length

            val stack = ArrayDeque<Char>(lenS)
            var count = 0
            for (ch in s) {
                if (stack.isEmpty() || stack.last() == ch) {
                    stack.addLast(ch)
                } else {
                    stack.removeLast()
                }
                if (stack.isEmpty()) {
                    ++count
                }
            }

            return count
        }
    }
}