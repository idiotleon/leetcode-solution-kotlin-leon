/**
 * https://leetcode.com/problems/optimal-account-balancing/
 *
 * Time Complexity:     O(`nDebts` * `range`)
 * Space Complexity:    O(`nTrans`) + O(`range`) ~ O(`range`)
 *
 * References:
 *  https://leetcode.com/problems/optimal-account-balancing/discuss/219187/Short-O(N-*-2N)-DP-solution-with-detailed-explanation-and-complexity-analysis
 */
package com.idiotleon.leetcode.lvl5.lc0465.withBit

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun minTransfers(transactions: Array<IntArray>): Int {
        // not used
        // val nTrans = transactions.size

        // to build up the debts map
        val debtMap = HashMap<Int, Int>()
        for ((person1, person2, bill) in transactions) {
            debtMap[person1] = (debtMap[person1] ?: 0) - bill
            debtMap[person2] = (debtMap[person2] ?: 0) + bill
        }

        // to build up the debts list
        val debts = debtMap.filterValues { it != 0 }.values.toMutableList()
        val nDebts = debts.size

        // the amount of total combinations (of debts)
        val range = 1 shl nDebts

        val dp = IntArray(range) { 0 }
        val sums = IntArray(range) { 0 }

        for (curBitMask in 0 until range) {
            for (idx in debts.indices) {
                if (curBitMask and (1 shl idx) == 0) { // if `debts[idx]` has never been taken before
                    val nextBitMask = curBitMask or (1 shl idx) // to take `debts[idx]`
                    sums[nextBitMask] = sums[curBitMask] + debts[idx]

                    dp[nextBitMask] = if (sums[nextBitMask] == 0) {
                        maxOf(dp[nextBitMask], 1 + dp[curBitMask])
                    } else {
                        maxOf(dp[nextBitMask], dp[curBitMask])
                    }
                }
            }
        }

        return nDebts - dp.last()
    }
}