/**
 * https://leetcode.com/problems/can-i-win/
 *
 * Time Complexity:     O(`n` * (2 ^ `n`))
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/can-i-win/discuss/95277/Java-solution-using-HashMap-with-detailed-explanation/99601
 *  https://leetcode.com/problems/can-i-win/discuss/95277/Java-solution-using-HashMap-with-detailed-explanation
 *  https://leetcode.com/problems/can-i-win/discuss/95320/Clean-C%2B%2B-beat-98.4-DFS-with-early-termination-check-(detailed-explanation)
 */
package com.zea7ot.leetcode.lvl4.lc0464

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean {
        if (desiredTotal <= 0) return true
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false

        val memo = HashMap<Int, Boolean>()
        return canIWin(0, desiredTotal, maxChoosableInteger, memo)
    }

    private fun canIWin(state: Int, desiredTotal: Int, n: Int, memo: HashMap<Int, Boolean>): Boolean {
        memo[state]?.let { return it }
        for (i in 0 until n) {
            if ((state and (1 shl i)) != 0) continue // the digit has been take before
            if (desiredTotal <= i + 1 || !canIWin(state or (1 shl i), desiredTotal - (i + 1), n, memo)) {
                memo[state] = true
                return true
            }
        }

        memo[state] = false
        return false
    }
}