package com.idiotleon.leetcode.lvl2.lc2109

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/adding-spaces-to-a-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1) / O(`lenS`)
 */
@Suppress(UNUSED)
class Solution0TwoPointers {
    private companion object {
        private const val SPACE = ' '
    }

    fun addSpaces(s: String, spaces: IntArray): String {
        val lenS = s.length
        var idxSpace = 0
        val nSpaces = spaces.size

        val builder = StringBuilder(lenS + nSpaces)
        for ((idxCh, ch) in s.withIndex()) {
            if (idxSpace < nSpaces && idxCh == spaces[idxSpace]) {
                builder.append(SPACE)
                ++idxSpace
            }
            builder.append(ch)
        }

        return builder.toString()
    }
}