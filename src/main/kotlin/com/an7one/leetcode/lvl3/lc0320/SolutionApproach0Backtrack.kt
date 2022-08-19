package com.an7one.leetcode.lvl3.lc0320

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/generalized-abbreviation/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/generalized-abbreviation/discuss/77218/Java-14ms-beats-100/427336
 */
@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun generateAbbreviations(word: String): List<String> {
        val ans = mutableListOf<String>()
        backtrack(0, 0, StringBuilder(), word, ans)
        return ans
    }

    private fun backtrack(
        idx: Int, count: Int, abbr: StringBuilder, word: String, res: MutableList<String>
    ) {
        val len = abbr.length

        if (idx == word.length) {
            if (count != 0) abbr.append(count)
            res.add(abbr.toString())
            if (count != 0) abbr.setLength(len)
            return
        }

        backtrack(idx + 1, count + 1, abbr, word, res)

        if (count != 0) abbr.append(count)
        backtrack(idx + 1, 0, abbr.append(word[idx]), word, res)

        abbr.setLength(len)
    }
}