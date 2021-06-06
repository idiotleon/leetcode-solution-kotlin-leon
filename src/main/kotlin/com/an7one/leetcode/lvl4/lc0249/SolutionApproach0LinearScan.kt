/**
 * https://leetcode.com/problems/group-shifted-strings/
 *
 * Time Complexity:     O(`nStrs` * ave_len_str)
 * Space Complexity:    O(`nStrs` * ave_len_str)
 *
 * Reference:
 *  https://leetcode.com/problems/group-shifted-strings/discuss/67442/My-Concise-JAVA-Solution/69322
 */
package com.an7one.leetcode.lvl4.lc0249

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    private companion object {
        private const val SPLITTER = ';'
    }

    fun groupStrings(strs: Array<String>): List<List<String>> {
        // not used
        // val nStrs = strs.size

        val hashToStrs = HashMap<String, MutableList<String>>()

        for (str in strs) {
            val hash = getHash(str)
            hashToStrs.getOrPut(hash) { mutableListOf() }.add(str)
        }

        return hashToStrs.values.toList()
    }

    private fun getHash(str: String): String {
        val lenS = str.length

        val builder = StringBuilder()

        for (idx in 1 until lenS) {
            val diff = str[idx] - str[idx - 1]
            builder.append(SPLITTER).append(if (diff < 0) diff + 26 else diff)
        }

        return builder.toString()
    }
}