package com.idiotleon.leetcode.lvl2.lc1945

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1) / O(`lenS`)
 */
@Suppress(UNUSED)
class Solution0ParseString {
    fun getLucky(s: String, k: Int): Int {
        val lenS = s.length
        val builder = StringBuilder(lenS)
        for (ch in s) {
            val tail = ch - 'a' + 1
            builder.append(tail.toString())
        }

        var str = builder.toString()
        for (op in 0 until k) {
            var sum = 0
            for (ch in str) {
                sum += ch - '0'
            }
            str = sum.toString()
        }

        return str.toInt()
    }
}