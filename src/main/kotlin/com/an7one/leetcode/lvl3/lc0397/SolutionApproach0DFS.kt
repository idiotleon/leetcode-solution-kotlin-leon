package com.an7one.leetcode.lvl3.lc0397

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/integer-replacement/
 *
 * Time Complexity:     O(lg(`n`))
 * Space Complexity:    O(lg(`n`))
 *
 * Reference:
 * https://leetcode.com/problems/integer-replacement/discuss/87920/A-couple-of-Java-solutions-with-explanations/232365
 */
@Suppress(UNUSED)
class SolutionApproach0DFS {
    fun integerReplacement(n: Int): Int {
        val memo = HashMap<Long, Int>()
        return dfs(n.toLong(), 0, memo)
    }

    private fun dfs(n: Long, steps: Int, memo: HashMap<Long, Int>): Int {
        memo[n]?.let { return steps + it }

        if (n == 1L) return steps
        if (n <= 0L) return Int.MAX_VALUE

        val minSteps = if (n % 2 == 0L) dfs(n / 2, 1 + steps, memo)
        else minOf(dfs(n + 1, 1 + steps, memo), dfs(n - 1, 1 + steps, memo))


        memo[n] = minSteps - steps
        return minSteps
    }
}