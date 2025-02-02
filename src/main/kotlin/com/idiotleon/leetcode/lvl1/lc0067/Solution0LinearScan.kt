package com.idiotleon.leetcode.lvl1.lc0067

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/add-binary/
 *
 * Time Complexity:     O(`lenA` + `lenB`) ~ O(maxOf(`lenA`, `lenB`))
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun addBinary(a: String, b: String): String {
        val lenA = a.length
        val lenB = b.length

        var idxA = lenA - 1
        var idxB = lenB - 1
        var carry = 0
        val builder = StringBuilder()

        while (idxA >= 0 || idxB >= 0 || carry > 0) {
            val digitA = if (idxA < 0) 0 else a[idxA] - '0'
            val digitB = if (idxB < 0) 0 else b[idxB] - '0'
            val sum = digitA + digitB + carry
            builder.append(sum % 2)
            carry = sum / 2

            --idxA
            --idxB
        }

        return builder.reverse().toString()
    }
}