/**
 * https://leetcode.com/problems/stone-game-vi/
 *
 * Time Complexity:     O(`nValues` * lg(`nValues`))
 * Space Complexity:    O(`nValues`)
 *
 * References:
 *  https://leetcode.com/problems/stone-game-vi/discuss/969574/JavaC%2B%2BPython-Sort-by-Value-Sum
 */
package com.idiotleon.leetcode.lvl3.lc1686

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun stoneGameVI(aliceValues: IntArray, bobValues: IntArray): Int {
        val nValues = aliceValues.size

        val sums = Array(nValues) { idx -> Sum(aliceValues[idx], bobValues[idx]) }
        sums.sortBy { -it.sum }

        var alice = 0
        var bob = 0
        for (idx in sums.indices) {
            val (aliceValue, bobValue) = sums[idx]
            if (idx % 2 == 0) {
                alice += aliceValue
            } else {
                bob += bobValue
            }
        }

        return alice.compareTo(bob)
    }

    private data class Sum(val aliceValue: Int, val bobValue: Int) {
        val sum = aliceValue + bobValue
    }
}