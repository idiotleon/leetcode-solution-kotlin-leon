/**
 * https://leetcode.com/problems/lexicographical-numbers/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/lexicographical-numbers/discuss/86231/Simple-Java-DFS-Solution
 */
package com.an7one.leetcode.lvl4.lc0386

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

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