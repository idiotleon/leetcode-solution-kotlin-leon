package com.idiotleon.leetcode.lvl5.lc0301

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/remove-invalid-parentheses/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/remove-invalid-parentheses/discuss/75041/Java-BFS-solution-16ms-avoid-generating-duplicate-strings
 */
@Suppress(UNUSED)
class Solution0Bfs1 {
    private companion object {
        private const val PAREN_OPEN = '('
        private const val PAREN_CLOSED = ')'
    }

    fun removeInvalidParentheses(str: String): List<String> {
        if (isValid(str)) {
            return listOf(str)
        }

        val ans = mutableListOf<String>()
        if (str.isEmpty()) {
            return ans
        }

        val queue = ArrayDeque<Node>().also {
            it.addLast(Node(str, 0, PAREN_CLOSED))
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val (strCur, idxStart, chRemoved) = queue.removeFirst()

                val lenS = strCur.length

                loop@ for (idx in idxStart until lenS) {
                    val ch = strCur[idx]
                    if (ch != PAREN_OPEN && ch != PAREN_CLOSED) {
                        continue@loop
                    }

                    if (idx > idxStart && strCur[idx - 1] == ch) {
                        continue@loop
                    }

                    if (chRemoved == PAREN_OPEN && ch == PAREN_CLOSED) {
                        continue@loop
                    }

                    val deleted = StringBuilder(strCur).deleteCharAt(idx).toString()

                    if (isValid(deleted)) {
                        ans.add(deleted)
                    } else if (ans.isEmpty()) {
                        queue.addLast(Node(deleted, idx, ch))
                    }
                }
            }
        }

        return ans
    }

    private fun isValid(str: String): Boolean {
        var stack = 0

        for (ch in str) {
            when (ch) {
                PAREN_OPEN -> ++stack
                PAREN_CLOSED -> {
                    if (--stack < 0) {
                        return false
                    }
                }

                else -> {
                }
            }
        }

        return stack == 0
    }

    private data class Node(val strCur: String, val idxStart: Int, val chRemoved: Char)
}