package com.an7one.leetcode.lvl4.lc0249

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/group-shifted-strings/
 *
 * Time Complexity:     O(`nStrs` * avg_len_str)
 * Space Complexity:    O(`nStrs` * avg_len_str)
 *
 * Reference:
 * https://leetcode.com/problems/group-shifted-strings/discuss/67442/My-Concise-JAVA-Solution/69322
 */
@Suppress(UNUSED)
class SolutionApproach0HashMap {
    private companion object {
        private const val SPLITTER = ","
    }

    fun groupStrings(strs: Array<String>): List<List<String>> {
        // not used
        // val nStrs = strs.size

        val hashToStr = HashMap<String, MutableList<String>>()

        for (str in strs) {
            val hash = hash(str)
            hashToStr.getOrPut(hash) { mutableListOf() }.add(str)
        }

        return hashToStr.values.toList()
    }

    private fun hash(str: String): String {
        val lenS = str.length

        val builder = StringBuilder()

        for (idx in 1 until lenS) {
            val diff = str[idx] - str[0]
            builder.append(SPLITTER).append(if (diff < 0) 26 + diff else diff)
        }

        return builder.toString()
    }
}