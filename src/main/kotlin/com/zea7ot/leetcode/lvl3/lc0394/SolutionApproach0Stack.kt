/**
 * https://leetcode.com/problems/decode-string/
 *
 * Time Complexity:     O(`lenS`) + O(max digit of `s`)
 * Space Complexity:    O(`lenS`) + O(max digit of `s`)
 *
 * References:
 *  https://leetcode.com/problems/decode-string/discuss/87534/Simple-Java-Solution-using-Stack/92413
 *  https://leetcode.com/problems/decode-string/discuss/87534/Simple-Java-Solution-using-Stack
 */
package com.zea7ot.leetcode.lvl3.lc0394

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val OPEN_SQUARE_BRACKET = '['
        private const val CLOSED_SQUARE_BRACKET = ']'
    }

    fun decodeString(s: String): String {
        // not used
        // val lenS = s.length

        // stack for repetitive times/numbers
        val repStack = LinkedList<Int>()
        // stack for substring StringBuilder(s)
        val subStack = LinkedList<StringBuilder>()

        var builder = StringBuilder()

        var repCnt = 0

        for (ch in s) {
            when (ch) {
                in '0'..'9' -> repCnt = repCnt * 10 + (ch - '0')
                OPEN_SQUARE_BRACKET -> {
                    repStack.push(repCnt)
                    subStack.push(builder)
                    builder = StringBuilder()
                    repCnt = 0
                }
                CLOSED_SQUARE_BRACKET -> {
                    val rep = repStack.pop()
                    val sub = builder
                    builder = subStack.pop()
                    builder.append(sub.repeat(rep))
                }
                else -> builder.append(ch)
            }
        }

        return builder.toString()
    }
}