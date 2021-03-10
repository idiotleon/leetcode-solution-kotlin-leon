/**
 * https://leetcode.com/problems/distribute-repeating-integers/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *   https://leetcode.com/problems/distribute-repeating-integers/discuss/935476/C++-oror-DP-oror-Bitmask/764600
 *   https://leetcode.com/problems/distribute-repeating-integers/discuss/935476/C%2B%2B-oror-DP-oror-Bitmask
 *   https://leetcode.com/problems/distribute-repeating-integers/discuss/935522/Step-by-step-optimization-more-than-10-methods
 */
package com.an7one.leetcode.lvl4.lc1655

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun canDistribute(nums: IntArray, quantity: IntArray): Boolean {
        // to turn `nums` into `numToFreq`,
        // also with range compression
        val numToFreq = HashMap<Int, Int>()
        for (num in nums) numToFreq[num] = 1 + (numToFreq[num] ?: 0)
        val nDistinct = numToFreq.size
        val freqs = mutableListOf<Int>()
        for ((_, freq) in numToFreq) {
            freqs.add(freq)
        }

        val nCustomers = quantity.size
        // the range of total possible combinations
        val range = 1 shl nCustomers

        val memo = Array(nDistinct) { Array<Boolean?>(range) { null } }
        return dfs(0, 0, freqs, quantity, memo)
    }

    private fun dfs(
        idxFreq: Int,
        curState: Int,
        freqs: List<Int>,
        quantity: IntArray,
        memo: Array<Array<Boolean?>>
    ): Boolean {

        val nFreqs = freqs.size
        val nCustomers = quantity.size
        // the range of total possible combinations
        val range = 1 shl nCustomers

        if (curState == range - 1) return true

        if (idxFreq == nFreqs) return false

        memo[idxFreq][curState]?.let { return it }

        var canDistribute = dfs(1 + idxFreq, curState, freqs, quantity, memo)

        for (nextState in 1 until range) {
            if (curState == nextState || curState != (curState and nextState)) continue

            var freqRequired = 0
            for (idxCustomer in quantity.indices) {
                if ((curState and (1 shl idxCustomer)) == 0 && (nextState and (1 shl idxCustomer)) > 0) {
                    freqRequired += quantity[idxCustomer]
                }

                // or equivalently
                // if(curState shl idxCustomer.inv() >= 0 && nextState shl idxCustomer.inv() < 0){
                //     freqRequired += quantity[idxCustomer]
                // }
            }

            if (freqRequired <= freqs[idxFreq]) {
                canDistribute = canDistribute || dfs(1 + idxFreq, nextState, freqs, quantity, memo)
            }

            if (canDistribute) break
        }

        memo[idxFreq][curState] = canDistribute
        return canDistribute
    }
}