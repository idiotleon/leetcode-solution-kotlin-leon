package com.idiotleon.leetcode.lvl2.lc0017

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Time Complexity:     O(3 ^ `lenD`)
 * Space Complexity:    O(`lenD`)
 */
@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private companion object {
        private val dialPad = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
    }

    fun letterCombinations(digits: String): List<String> {
        // not used
        // val lenD = digits.length

        val ans = ArrayList<String>()
        if (digits.isEmpty()) return ans

        val builder = StringBuilder()
        backtrack(0, digits, builder, ans)
        return ans
    }

    private fun backtrack(idx: Int, digits: String, builder: StringBuilder, res: ArrayList<String>) {
        val len = digits.length
        if (idx == len) {
            res.add(builder.toString())
            return
        }

        val candidates = dialPad[digits[idx] - '0']

        for (ch in candidates) {
            builder.append(ch)
            backtrack(idx + 1, digits, builder, res)
            builder.deleteCharAt(builder.length - 1)
        }
    }
}