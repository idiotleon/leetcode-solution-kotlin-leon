/**
 * https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 *
 * Time Complexity:     O((lg(`k`)) ^ 2)
 * Space Complexity:    O(lg(`k`))
 *
 * References:
 *  https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/discuss/585632/JavaC%2B%2BPython-Easy-Prove
 */
package com.zea7ot.leetcode.lvl3.lc1414

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun findMinFibonacciNumbers(k: Int) = dfs(k)

    private fun dfs(k: Int): Int {
        if (k < 2) return k

        var fib1 = 1
        var fib2 = 1

        while (fib2 <= k) {
            fib2 += fib1
            fib1 = fib2 - fib1
        }

        return 1 + dfs(k - fib1)
    }
}