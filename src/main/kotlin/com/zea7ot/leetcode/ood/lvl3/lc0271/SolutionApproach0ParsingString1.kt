/**
 * https://leetcode.com/problems/encode-and-decode-strings/
 *
 * Time Complexities:
 *  encode():
 *  decode():
 *
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/encode-and-decode-strings/discuss/70412/AC-Java-Solution
 */
package com.zea7ot.leetcode.ood.lvl3.lc0271

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ParsingString1 {
    private companion object {
        private const val SPLITTER = '/'
    }

    // Encodes a list of strings to a single string.
    fun encode(strs: List<String>): String {
        val builder = StringBuilder()
        for (str in strs) {
            builder.append(str.length).append(SPLITTER).append(str)
        }
        return builder.toString()
    }

    // Decodes a single string to a list of strings.
    fun decode(str: String): List<String> {
        val ans = ArrayList<String>()

        var idx = 0
        while (idx < str.length) {
            val slashIdx = str.indexOf(SPLITTER, idx)
            val len = str.substring(idx, slashIdx).toInt()
            idx = slashIdx + len + 1
            ans.add(str.substring(slashIdx + 1, idx))
        }

        return ans
    }
}