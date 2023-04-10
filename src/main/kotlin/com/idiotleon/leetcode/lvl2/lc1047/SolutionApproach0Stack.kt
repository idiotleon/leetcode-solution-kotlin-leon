/**
 * @author: Leon
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 */
package com.idiotleon.leetcode.lvl2.lc1047

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Stack {
    fun removeDuplicates(str: String): String {
        // not used
        // val lenS = str.length

        val builder = StringBuilder()

        for (ch in str) {
            if (builder.isNotEmpty() && builder.last() == ch)
                builder.deleteCharAt(builder.length - 1)
            else
                builder.append(ch)
        }

        return builder.toString()
    }
}