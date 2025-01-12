package com.idiotleon.leetcode.lvl5.lc0301

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/remove-invalid-parentheses/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/Share-my-Java-BFS-solution
 */
@Suppress(UNUSED)
class Solution0Bfs {
    private companion object {
        private const val PAREN_OPEN = '('
        private const val PAREN_CLOSED = ')'
    }

    fun removeInvalidParentheses(str: String): List<String> {
        val ans = mutableListOf<String>()
        if (str.isEmpty()) {
            return ans
        }

        val queue = ArrayDeque<String>().also {
            it.addLast(str)
        }

        val seen = HashSet<String>().also {
            it.add(str)
        }

        var found = false

        while (queue.isNotEmpty()) {
            val size = queue.size

            outer@ for (sz in 0 until size) {
                val cur = queue.removeFirst()

                if (isValid(cur)) {
                    ans.add(cur)
                    found = true
                }

                if (found) {
                    continue@outer
                }

                inner@ for (idx in cur.indices) {
                    if (cur[idx] != PAREN_OPEN && cur[idx] != PAREN_CLOSED) {
                        continue@inner
                    }

                    val deleted = StringBuilder(cur).deleteCharAt(idx).toString()

                    if (seen.add(deleted)) {
                        queue.remove(deleted)
                    }
                }
            }
        }

        return ans
    }

    private fun isValid(str: String): Boolean {
        var count = 0

        for (ch in str) {
            when (ch) {
                PAREN_OPEN -> ++count
                PAREN_CLOSED -> {
                    if (--count < 0) {
                        return false
                    }
                }
            }
        }

        return count == 0
    }
}