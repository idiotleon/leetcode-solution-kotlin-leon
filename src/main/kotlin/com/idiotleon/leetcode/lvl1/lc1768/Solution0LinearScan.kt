package com.idiotleon.leetcode.lvl1.lc1768

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 *
 * Time Complexity:     O(`len1` + `len2`) ~ O(maxOf(`len1`, `len2`))
 * Space Complexity:    O(1) / O(maxOf(`len1`, `len2`))
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun mergeAlternately(word1: String, word2: String): String {
        val len1 = word1.length
        val len2 = word2.length

        var idx = 0

        val builder = StringBuilder()
        while (idx < minOf(len1, len2)) {
            builder.append(word1[idx])
            builder.append(word2[idx])

            ++idx
        }

        if (idx < len1) {
            builder.append(word1.substring(idx))
        }

        if (idx < len2) {
            builder.append(word2.substring(idx))
        }

        return builder.toString()
    }
}