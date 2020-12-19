/**
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * the same problem:
 *  https://leetcode.com/problems/remove-duplicate-letters/
 */
package com.zea7ot.leetcode.lvl4.lc1081

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun smallestSubsequence(s: String): String {
        val lenS = s.length

        val used = IntArray(26) { 0 }
        val remaining = IntArray(26) { 0 }
        for (ch in s) {
            ++remaining[ch - 'a']
        }

        val builder = StringBuilder()

        for (idx in 0 until lenS) {
            if (used[s[idx] - 'a'] == 0) {
                while (builder.isNotEmpty()
                    && builder.last() >= s[idx]
                    && remaining[builder.last() - 'a'] > 0
                ) {

                    --used[builder.last() - 'a']
                    builder.deleteCharAt(builder.length - 1)
                }

                builder.append(s[idx])
                ++used[s[idx] - 'a']
            }

            --remaining[s[idx] - 'a']
        }

        return builder.toString()
    }
}