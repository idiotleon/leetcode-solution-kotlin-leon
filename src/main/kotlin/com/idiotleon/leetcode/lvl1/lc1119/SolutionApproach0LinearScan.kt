/**
 * @author: Leon
 * https://leetcode.com/problems/remove-vowels-from-a-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`) / O(1)
 */
package com.idiotleon.leetcode.lvl1.lc1119

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    private companion object {
        private val vowels = hashSetOf('a', 'e', 'i', 'o', 'u')
    }

    fun removeVowels(S: String): String {
        // not used
        // val lenS = S.length

        val builder = StringBuilder()

        for (ch in S) {
            if (vowels.contains(ch))
                continue

            builder.append(ch)
        }

        return builder.toString()
    }
}