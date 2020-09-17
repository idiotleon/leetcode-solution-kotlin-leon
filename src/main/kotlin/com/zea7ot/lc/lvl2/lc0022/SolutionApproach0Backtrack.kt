/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Time Complexity:     O(2 ^ (2 * `n`))
 * Space Complexity:    O(2 * `n`) ~ O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
 *  https://leetcode.com/problems/generate-parentheses/discuss/10098/Java-DFS-way-solution/116003
 */
package com.zea7ot.lc.lvl2.lc0022

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private companion object {
        private const val OPEN_PAREN = '('
        private const val CLOSED_PAREN = ')'
    }

    fun generateParenthesis(n: Int): List<String> {
        val ans: ArrayList<String> = arrayListOf()
        if (n < 1) return ans

        val builder = StringBuilder()
        backtrack(builder, 0, 0, n, ans)

        return ans
    }

    private fun backtrack(builder: StringBuilder,
                          cntOpen: Int,
                          cntClosed: Int,
                          n: Int,
                          ans: ArrayList<String>) {

        if (builder.length == 2 * n) {
            ans.add(builder.toString())
            return
        }

        if (cntOpen < n) {
            builder.append(OPEN_PAREN)
            backtrack(builder, cntOpen + 1, cntClosed, n, ans)
            builder.deleteCharAt(builder.length - 1)
        }

        if (cntClosed < cntOpen) {
            builder.append(CLOSED_PAREN)
            backtrack(builder, cntOpen, cntClosed + 1, n, ans)
            builder.deleteCharAt(builder.length - 1)
        }
    }
}