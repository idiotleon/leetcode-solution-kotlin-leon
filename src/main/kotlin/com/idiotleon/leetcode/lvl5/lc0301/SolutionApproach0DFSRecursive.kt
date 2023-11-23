package com.idiotleon.leetcode.lvl5.lc0301

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/remove-invalid-parentheses/
 *
 * Time Complexity:     O((OPEN_PAREN + CLOSED_PAREN) * (2 ^ (OPEN_PAREN + CLOSED_PAREN))) ~ O(`lenS` * (2 ^ `lenS`))
 * Space Complexity:    O((OPEN_PAREN + CLOSED_PAREN) ^ 2) ~ O(`lenS` ^ 2)
 *
 * Reference:
 * https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution/113024
 * https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution/156556
 * https://zxi.mytechroad.com/blog/searching/leetcode-301-remove-invalid-parentheses/
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private const val PAREN_OPEN = '('
        private const val PAREN_CLOSED = ')'
    }

    fun removeInvalidParentheses(s: String): List<String> {
        val ans = mutableListOf<String>()
        dfs(0, 0, s, PAREN_OPEN, PAREN_CLOSED, ans)
        return ans
    }

    private fun dfs(
        loStart: Int, hiStart: Int, str: String, parenOpen: Char, parenClosed: Char, res: MutableList<String>
    ) {
        val lenS = str.length

        var stack = 0
        loop@ for (hi in hiStart until lenS) {
            if (str[hi] == parenOpen) {
                ++stack
            }
            if (str[hi] == parenClosed) {
                --stack
            }
            // after this if block, there will be one surplus closed parenthesis to remove
            if (stack >= 0) {
                continue@loop
            }

            for (lo in loStart..hi) { // to try to remove one at each position, skipping duplicates
                if (str[lo] == parenClosed && (lo == 0 || str[lo - 1] != parenClosed)) { // only to remove the first one of the duplicates
                    // to remove the char at index `lo`
                    // time complexity: O(`lenS`)
                    val deleted = StringBuilder(str).deleteCharAt(lo).toString()
                    // or equivalently
                    // val deleted = str.substring(0, lo) + str.substring(lo + 1)
                    dfs(lo, hi, deleted, parenOpen, parenClosed, res)
                }
            }

            return
        }

        // no invalid parenthesis has been detected,
        // to check the opposite direction.
        val reversed = str.reversed()
        if (parenOpen == PAREN_OPEN) {
            dfs(0, 0, reversed, PAREN_CLOSED, PAREN_OPEN, res)
        } else {
            res.add(reversed)
        }
    }
}