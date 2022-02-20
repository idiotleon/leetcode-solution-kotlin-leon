/**
 * @author: Leon
 * https://leetcode.com/problems/beautiful-arrangement/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/beautiful-arrangement/discuss/99707/Java-Solution-Backtracking
 */
package com.an7one.leetcode.lvl3.lc0526

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private var count = 0

    fun countArrangement(n: Int): Int {
        if (n == 0) return 0

        val used = BooleanArray(n + 1) { false }
        backtrack(1, n, used)
        return count
    }

    private fun backtrack(curNum: Int, n: Int, used: BooleanArray) {
        if (curNum > n) {
            ++count
            return
        }

        for (idx in 1..n) {
            if (!used[idx] && (idx % curNum == 0 || curNum % idx == 0)) {
                used[idx] = true
                backtrack(1 + curNum, n, used)
                used[idx] = false
            }
        }
    }
}