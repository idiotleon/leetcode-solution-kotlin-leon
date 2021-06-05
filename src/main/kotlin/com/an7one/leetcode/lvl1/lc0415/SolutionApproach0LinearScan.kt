/**
 * https://leetcode.com/problems/add-strings/
 *
 * Time Complexity:     O(`len1` + `len2`) ~ O(maxOf(`len1`, `len2`))
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/add-strings/discuss/90436/Straightforward-Java-8-main-lines-25ms
 */
package com.an7one.leetcode.lvl1.lc0415

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun addStrings(num1: String, num2: String): String {
        val len1 = num1.length
        val len2 = num2.length

        var idx1 = len1 - 1
        var idx2 = len2 - 1

        val builder = StringBuilder()

        var carry = 0

        while (idx1 >= 0 || idx2 >= 0 || carry > 0) {
            val digit1 = if (idx1 >= 0) num1[idx1] - '0' else 0
            val digit2 = if (idx2 >= 0) num2[idx2] - '0' else 0
            val sum = digit1 + digit2 + carry
            builder.append(sum % 10)
            carry = sum / 10

            --idx1
            --idx2
        }

        return builder.reverse().toString()
    }
}