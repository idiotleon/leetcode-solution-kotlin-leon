/**
 * https://leetcode.com/problems/beautiful-arrangement/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/beautiful-arrangement/discuss/99707/Java-Solution-Backtracking/540790
 *  https://leetcode.com/problems/beautiful-arrangement/discuss/99707/Java-Solution-Backtracking
 */
package com.idiotleon.leetcode.lvl3.lc0526.withBit

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun countArrangement(n: Int): Int {
        val memo = Array<Int?>(1 shl n) { null }
        return dfs(0, 0, n, memo)
    }

    private fun dfs(curNum: Int, curState: Int, n: Int, memo: Array<Int?>): Int {
        if (curNum >= n) return 1
        memo[curState]?.let { return it }

        var sum = 0
        for (idx in 0 until n) {
            if ((curState and (1 shl idx)) > 0) continue

            if ((idx + 1) % (curNum + 1) == 0 || (curNum + 1) % (idx + 1) == 0) {
                val nextState = curState or (1 shl idx)
                sum += dfs(curNum + 1, nextState, n, memo)
            }
        }

        memo[curState] = sum
        return sum
    }
}