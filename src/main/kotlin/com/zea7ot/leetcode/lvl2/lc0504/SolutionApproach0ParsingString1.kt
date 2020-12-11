/**
 * https://leetcode.com/problems/base-7/
 *
 * Time Complexity:     O(lg(`n`)), 7-base
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/base-7/discuss/98363/Verbose-Java-Solution
 */
package com.zea7ot.leetcode.lvl2.lc0504

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0ParsingString1 {
    fun convertToBase7(n: Int): String {
        var num = n
        if (num == 0) return "0"

        val builder = StringBuilder()
        var isNegative = false

        if (num < 0) {
            isNegative = true
        }

        while (num != 0) {
            builder.append(abs(num % 7))
            num /= 7
        }

        if (isNegative) builder.append("-")

        return builder.reverse().toString()
    }
}