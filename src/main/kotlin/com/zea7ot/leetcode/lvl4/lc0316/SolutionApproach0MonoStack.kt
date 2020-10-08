/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 *
 * to main a "strickly increasing" stack
 *  1. the contents are actual characters
 *  2. the order of characters is maintained in strictly increasing order, if possible
 *      by "if possible", it rather depends on the given String sequence,
 *      in another words, how many letters left, and what they are
 */
package com.zea7ot.leetcode.lvl4.lc0316

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun removeDuplicateLetters(s: String): String {
        val lenS = s.length

        val remaining = IntArray(26)
        val used = IntArray(26)
        for (ch in s) {
            ++remaining[ch - 'a']
        }

        val builder = StringBuilder()
        for (idx in 0 until lenS) {
            if (used[s[idx] - 'a'] == 0) {
                while (builder.isNotEmpty()
                        && builder.last() >= s[idx]
                        && remaining[builder.last() - 'a'] > 0) {

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