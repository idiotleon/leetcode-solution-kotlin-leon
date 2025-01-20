package com.idiotleon.leetcode.lvl2.lc2384

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/largest-palindromic-number/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1) / O(`lenS`)
 */
@Suppress(UNUSED)
class Solution0ParseString {
    fun largestPalindromic(s: String): String {
        val lenS = s.length

        val freqs = IntArray(10) { 0 }.also {
            for (ch in s) {
                ++it[ch - '0']
            }
        }

        val builder = StringBuilder()
        var single: Int? = null
        for (idx in 9 downTo 0) {
            val freq = freqs[idx]
            if (freq == 0) {
                continue
            }
            if (single == null && freq % 2 == 1) {
                single = idx
            }
            // to avoid leading zero
            if (idx == 0 && builder.isEmpty()) {
                break
            }
            val repeatCount = freq / 2
            builder.append((idx.toString()).repeat(repeatCount))
        }

        val rev = StringBuilder(builder).reverse()
        single?.let { builder.append(single) }
        builder.append(rev)

        return if (builder.isEmpty()) "0" else builder.toString()
    }
}