/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Time Complexity:     O(2 ^ (2 * `n`))
 * Space Complexity:    O(2 * `n`) ~ O(`n`)
 *
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485115&idx=1&sn=dd64bfedb1da22f308228a0933583adf&chksm=9bd7f8b3aca071a5b96e7cb9464c01c045997d36d677b14163b6b009df2aa9b1b613ace3bc5a&scene=178&cur_album_id=1318883740306948097#rd
 *  https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
 *  https://leetcode.com/problems/generate-parentheses/discuss/10098/Java-DFS-way-solution/116003
 */
package com.an7one.leetcode.lvl2.lc0022

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private companion object {
        private const val OPEN_PAREN = '('
        private const val CLOSED_PAREN = ')'
    }

    fun generateParenthesis(n: Int): List<String> {
        val ans = mutableListOf<String>()
        if (n < 1) return ans

        val builder = StringBuilder()
        backtrack(builder, 0, 0, n, ans)

        return ans
    }

    private fun backtrack(builder: StringBuilder,
                          cntOpen: Int,
                          cntClosed: Int,
                          n: Int,
                          res: MutableList<String>) {

        if (builder.length == 2 * n) {
            res.add(builder.toString())
            return
        }

        val len = builder.length

        if (cntOpen < n) {
            builder.append(OPEN_PAREN)
            backtrack(builder, cntOpen + 1, cntClosed, n, res)
            builder.setLength(len)
        }

        if (cntClosed < cntOpen) {
            builder.append(CLOSED_PAREN)
            backtrack(builder, cntOpen, cntClosed + 1, n, res)
            builder.setLength(len)
        }
    }
}