/**
 * https://leetcode.com/problems/decode-string/
 *
 * Time Complexity:     O(`lenS`) + O(max digit of `s`)
 * Space Complexity:    O(`lenS`) + O(max digit of `s`)
 *
 * References:
 *  https://leetcode.com/problems/decode-string/discuss/210284/Java-Recursive
 */
package com.zea7ot.leetcode.lvl3.lc0394

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private const val OPEN_SQUARE_BRACKET = '['
        private const val CLOSED_SQUARE_BRACKET = ']'
    }

    fun decodeString(s: String): String {
        // not used
        // val lenS = s.length

        val queue = LinkedList<Char>()
        for (ch in s) queue.offer(ch)

        return dfs(queue)
    }

    private fun dfs(queue: LinkedList<Char>): String {
        val builder = StringBuilder()
        var repCnt = 0

        loop@ while (queue.isNotEmpty()) {
            when (val ch = queue.poll()) {
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