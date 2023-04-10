/**
 * https://leetcode.com/problems/encode-and-decode-strings/
 *
 * Time Complexities:
 *  encode():               O()
 *  decode():               O()
 *
 * Space Complexity:        O()
 *
 * References:
 *  https://leetcode.com/problems/encode-and-decode-strings/discuss/70402/Java-with-%22escaping%22
 */
package com.idiotleon.leetcode.ood.lvl3.lc0271

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ParsingString {
    private companion object {
        private const val HASH = "#"
        private const val DOUBLE_HASH = "##"
        private const val SEPARATOR = " # "
    }

    // Encodes a list of strings to a single string.
    fun encode(strs: List<String>): String {
        val builder = StringBuilder()
        for (str in strs) {
            builder.append(str.replace(HASH, DOUBLE_HASH)).append(SEPARATOR)
        }
        return builder.toString()
    }

    // Decodes a single string to a list of strings.
    fun decode(str: String): List<String> {
        val ans = ArrayList<String>()

        val strs = str.split(SEPARATOR)
        for (idx in 0 until strs.size - 1) {
            ans.add(strs[idx].replace(DOUBLE_HASH, HASH))
        }

        return ans
    }
}