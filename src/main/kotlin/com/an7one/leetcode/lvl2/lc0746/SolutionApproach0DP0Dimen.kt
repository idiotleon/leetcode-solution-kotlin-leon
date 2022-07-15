package com.an7one.leetcode.lvl2.lc0746

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 * Time Complexity:     O(`nCosts`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/min-cost-climbing-stairs/discuss/476388/4-ways-or-Step-by-step-from-Recursion-greater-top-down-DP-greater-bottom-up-DP-greater-fine-tuning
 */
@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun minCostClimbingStairs(costs: IntArray): Int {
        val nCosts = costs.size

        var first = costs[0]
        var second = costs[1]
        if (nCosts == 2) return minOf(first, second)

        for (idx in 2 until nCosts) {
            val cur = costs[idx] + minOf(first, second)
            first = second
            second = cur
        }

        return minOf(first, second)
    }
}