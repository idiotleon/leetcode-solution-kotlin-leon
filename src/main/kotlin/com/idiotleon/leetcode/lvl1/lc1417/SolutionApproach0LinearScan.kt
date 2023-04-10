/**
 * https://leetcode.com/problems/reformat-the-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/reformat-the-string/discuss/586666/Java-Use-Character.isDigit()/509546
 */
package com.idiotleon.leetcode.lvl1.lc1417

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun reformat(s: String): String {
        // not used
        // val lenS = s.length

        val digits = LinkedList<Char>()
        val chars = LinkedList<Char>()

        for (ch in s) {
            when (ch) {
                in '0'..'9' -> digits.offer(ch)
                else -> chars.offer(ch)
            }
        }

        val totalDigits = digits.size
        val totalChars = chars.size
        if (abs(totalDigits - totalChars) >= 2)
            return ""

        val builder = StringBuilder()
        var isDigit = totalDigits >= totalChars
        for (idx in s.indices) {
            if (isDigit) {
                builder.append(digits.poll())
            } else {
                builder.append(chars.poll())
            }

            isDigit = !isDigit
        }

        return builder.toString()
    }
}