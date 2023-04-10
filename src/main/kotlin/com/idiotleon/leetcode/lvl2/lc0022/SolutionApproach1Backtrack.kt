package com.idiotleon.leetcode.lvl2.lc0022

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Time Complexity:     O(2 ^ (2 * `n`) * ave_len_ans)
 * Space Complexity:    O(2 * `n`) ~ O(`n`)
 *
 * Reference:
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485115&idx=1&sn=dd64bfedb1da22f308228a0933583adf&chksm=9bd7f8b3aca071a5b96e7cb9464c01c045997d36d677b14163b6b009df2aa9b1b613ace3bc5a&scene=178&cur_album_id=1318883740306948097#rd
 * https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
 * https://leetcode.com/problems/generate-parentheses/discuss/10098/Java-DFS-way-solution/116003
 */
@Suppress(UNUSED)
class SolutionApproach1Backtrack {
    private companion object {
        private const val PAREN_OPEN = '('
        private const val PAREN_CLOSED = ')'
    }

    fun generateParenthesis(n: Int): List<String> {
        val ans = mutableListOf<String>()

        backtrack("", 0, 0, n, ans)

        return ans
    }

    private fun backtrack(str: String, cntOpen: Int, cntClosed: Int, n: Int, res: MutableList<String>) {
        val lenS = str.length
        if (lenS == 2 * n) res.add(str)

        if (cntOpen < n) backtrack(str + PAREN_OPEN, cntOpen + 1, cntClosed, n, res)

        if (cntClosed < cntOpen) backtrack(str + PAREN_CLOSED, cntOpen, cntClosed + 1, n, res)
    }
}