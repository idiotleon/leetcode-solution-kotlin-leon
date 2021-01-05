/**
 * https://leetcode.com/problems/super-palindromes/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/super-palindromes/discuss/174835/tell-you-how-to-get-all-super-palindrome(detailed-explanation)/778409
 *  https://leetcode.com/problems/super-palindromes/discuss/174835/tell-you-how-to-get-all-super-palindrome(detailed-explanation)
 */
package com.zea7ot.leetcode.lvl4.lc0906

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ParsingString {
    fun superpalindromesInRange(L: String, R: String): Int {
        val palindromes = mutableListOf<Long>()

        val low = L.toLong()
        val high = R.toLong()

        for (num in 1L..9L) {
            palindromes.add(num)
        }

        for (num in 1 until 10000) {
            val loStr = num.toString()
            val hiStr = StringBuilder(loStr).reverse().toString()
            palindromes.add((loStr + hiStr).toLong())

            for (d in 0L..9L) {
                palindromes.add((loStr + d + hiStr).toLong())
            }
        }

        var count = 0
        for (palindrome in palindromes) {
            val square = palindrome * palindrome

            if (!isPalindrome(square.toString())) continue

            if (square in low..high) {
                ++count
            }
        }

        return count
    }

    private fun isPalindrome(str: String): Boolean {
        var lo = 0
        var hi = str.lastIndex

        while (lo < hi) {
            if (str[lo] != str[hi])
                return false

            ++lo
            --hi
        }

        return true
    }
}