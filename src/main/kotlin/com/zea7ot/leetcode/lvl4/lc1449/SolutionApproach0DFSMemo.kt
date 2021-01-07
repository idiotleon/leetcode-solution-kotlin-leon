/**
 * https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *
 */
package com.zea7ot.leetcode.lvl4.lc1449

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    class Solution {
        fun largestNumber(costs: IntArray, target: Int): String {
            val memo = Array<String?>(1 + target) { null }
            return dfs(target, costs, memo)
        }

        private fun dfs(target: Int, costs: IntArray, memo: Array<String?>): String {
            if (target < 0) return "0"
            if (target == 0) return ""

            memo[target]?.let { return it }

            var res = "0"
            for (digit in 9 downTo 1) {
                val str = dfs(target - costs[digit - 1], costs, memo)
                if (str == "0") continue

                val cur = digit.toString() + str
                if (res == "0" || cur.length > res.length) {
                    res = cur
                }
            }

            memo[target] = res
            return res
        }
    }
}