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
class SolutionApproach0StringParsing1 {
    private companion object {
        private val LESS_THAN_20 = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")

        private val TENS = arrayOf("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

        private val THOUSANDS = arrayOf("", "Thousand", "Million", "Billion")
    }

    fun numberToWords(num: Int): String {
        if (num == 0) return "Zero"

        var i = 0
        var words = ""
        var res = num

        while (res > 0) {
            if (res % 1000 != 0) {
                words = "${helper(res % 1000)}${THOUSANDS[i]} $words"
            }

            res /= 1000
            ++i
        }

        return words.trim()
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