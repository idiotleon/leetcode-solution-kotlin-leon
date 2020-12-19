/**
 * https://leetcode.com/problems/integer-to-english-words/
 *
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/integer-to-english-words/discuss/70625/My-clean-Java-solution-very-easy-to-understand
 */
package com.zea7ot.leetcode.lvl5.lc0273

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0StringParsing {
    private companion object {
        private val LESS_THAN_20 = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")

        private val TENS = arrayOf("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

        private val THOUSANDS = arrayOf("Billion", "Million", "Thousand", "")

        private val RADIX = arrayOf(1e9.toInt(), 1e6.toInt(), 1e3.toInt(), 1)
    }

    fun numberToWords(num: Int): String {
        if (num == 0) return "Zero"

        val builder = StringBuilder()
        var res = num

        for (i in RADIX.indices) {
            if (res / RADIX[i] == 0) continue
            builder.append(helper(res / RADIX[i])).append(THOUSANDS[i]).append(" ")
            res %= RADIX[i]
        }

        return builder.toString().trim()
    }

    private fun helper(num: Int): String {
        return when (num) {
            0 -> ""
            in 1 until 20 -> "${LESS_THAN_20[num]} "
            in 20 until 100 -> "${TENS[num / 10]} ${helper(num % 10)}"
            else -> "${LESS_THAN_20[num / 100]} Hundred ${helper(num % 100)}"
        }
    }
}