package com.idiotleon.leetcode.lvl3.lc0394

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.collections.ArrayDeque

/**
 * @author: Leon
 * https://leetcode.com/problems/decode-string/
 *
 * Time Complexity:     O(`lenS`) + O(max digit of `s`)
 * Space Complexity:    O(`lenS`) + O(max digit of `s`)
 *
 * Reference:
 * https://leetcode.com/problems/decode-string/discuss/210284/Java-Recursive
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private const val OPEN_SQUARE_BRACKET = '['
        private const val CLOSED_SQUARE_BRACKET = ']'
    }

    fun decodeString(s: String): String {
        // not used
        // val lenS = s.length

        val queue = ArrayDeque<Char>()
        for (ch in s) {
            queue.addLast(ch)
        }

        return dfs(queue)
    }

    private fun dfs(queue: ArrayDeque<Char>): String {
        val builder = StringBuilder()
        var repCnt = 0

        loop@ while (queue.isNotEmpty()) {
            when (val ch = queue.removeFirst()) {
                in '0'..'9' -> repCnt = repCnt * 10 + (ch - '0')
                OPEN_SQUARE_BRACKET -> {
                    val sub = dfs(queue)
                    builder.append(sub.repeat(repCnt))
                    repCnt = 0
                }

                CLOSED_SQUARE_BRACKET -> {
                    break@loop
                }

                else -> builder.append(ch)
            }
        }

        return builder.toString()
    }
}