/**
 * https://leetcode.com/problems/rearrange-spaces-between-words/
 *
 * Time Complexity:     O(`lenT`)
 * Space Complexity:    O(`lenT`) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/rearrange-spaces-between-words/discuss/855335/JavaPython-3-6-liners-w-analysis.
 */
package com.an7one.leetcode.lvl2.lc1592

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ParsingString {
    private companion object {
        private const val SPACE = ' '
    }

    fun reorderSpaces(text: String): String {
        // not used
        // val lenT = text.length

        val words = text.trim().split("\\s+".toRegex())
        val nWords = words.size
        val cntSpace = text.filter { it == SPACE }.count()
        val gap = if (nWords <= 1) 0 else cntSpace / (nWords - 1)
        val cntTrailingSpace = cntSpace - gap * (nWords - 1)

        return "${words.joinToString(SPACE.toString().repeat(gap))}${SPACE.toString().repeat(cntTrailingSpace)}"
    }
}