/**
 * https://leetcode.com/problems/optimal-account-balancing/
 *
 * Time Complexity:     O(`nTrans`!)
 * Space Complexity:    O(`nTrans`)
 *
 * References:
 *  https://leetcode.com/problems/optimal-account-balancing/discuss/95355/Concise-9ms-DFS-solution-(detailed-explanation)/142043
 *  https://leetcode.com/problems/optimal-account-balancing/discuss/95355/Concise-9ms-DFS-solution-(detailed-explanation)
 */
package com.zea7ot.leetcode.lvl5.lc0465

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun minTransfers(transactions: Array<IntArray>): Int {
        // not used
        // val nTrans = transactions.size

        val debtMap = HashMap<Int, Int>()
        for ((person1, person2, bill) in transactions) {
            debtMap[person1] = (debtMap[person1] ?: 0) - bill
            debtMap[person2] = (debtMap[person2] ?: 0) + bill
        }

        return backtrack(0, debtMap.values.toMutableList())
    }

    private fun backtrack(idxStart: Int, debts: MutableList<Int>): Int {
        val nDebts = debts.size
        var idxStart = idxStart
        while (idxStart < nDebts && debts[idxStart] == 0) ++idxStart

        if (idxStart == nDebts)
            return 0

        var res = Int.MAX_VALUE
        for (idx in idxStart + 1 until nDebts) {
            if (debts[idxStart] * debts[idx] < 0) {

                debts[idx] += debts[idxStart]
                res = minOf(res, 1 + backtrack(idxStart + 1, debts))
                debts[idx] -= debts[idxStart]
            }
        }

        return res
    }
}