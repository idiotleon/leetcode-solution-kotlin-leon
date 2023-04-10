package com.idiotleon.leetcode.lvl4.lc0386

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/lexicographical-numbers/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/lexicographical-numbers/discuss/86231/Simple-Java-DFS-Solution
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun lexicalOrder(n: Int): List<Int> {
        val ans = mutableListOf<Int>()
        for (digit in 1 until 10) {
            dfs(digit, n, ans)
        }

        return ans
    }

    private fun dfs(cur: Int, n: Int, res: MutableList<Int>) {
        if (cur > n) return

        res.add(cur)
        for (digit in 0 until 10) {
            if (10 * cur + digit > n) return
            dfs(10 * cur + digit, n, res)
        }
    }
}