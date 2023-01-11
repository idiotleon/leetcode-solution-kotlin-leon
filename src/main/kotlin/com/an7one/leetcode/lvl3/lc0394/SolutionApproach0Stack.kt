package com.an7one.leetcode.lvl3.lc0394

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.ArrayDeque

/**
 * @author: Leon
 * https://leetcode.com/problems/decode-string/
 *
 * Time Complexity:     O(`lenS`) + O(max digit of `s`)
 * Space Complexity:    O(`lenS`) + O(max digit of `s`)
 *
 * Reference:
 * https://leetcode.com/problems/decode-string/discuss/87534/Simple-Java-Solution-using-Stack/92413
 * https://leetcode.com/problems/decode-string/discuss/87534/Simple-Java-Solution-using-Stack
 */
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
        val repStack = ArrayDeque<Int>()
        // stack for substring StringBuilder(s)
        val subStack = ArrayDeque<StringBuilder>()

        var builder = StringBuilder()

        var cntRep = 0

        for (ch in s) {
            when (ch) {
                in '0'..'9' -> cntRep = cntRep * 10 + (ch - '0')
                OPEN_SQUARE_BRACKET -> {
                    repStack.addLast(cntRep)
                    subStack.addLast(builder)
                    builder = StringBuilder()
                    cntRep = 0
                }

                CLOSED_SQUARE_BRACKET -> {
                    val rep = repStack.removeLast()
                    val sub = builder
                    builder = subStack.removeLast()
                    builder.append(sub.repeat(rep))
                }

                else -> builder.append(ch)
            }
        }

        return builder.toString()
    }
}