/**
 * https://leetcode.com/problems/random-pick-with-weight/
 *
 * Time Complexities:
 *  initialization:     O(`nWeights`)
 *  `pickIndex()`:      O(lg(`nWeights`))
 *
 * Space Complexity:    O(`nWeights`)
 *
 * References:
 *  https://leetcode.com/problems/random-pick-with-weight/discuss/154044/Java-accumulated-freq-sum-and-binary-search
 */
package com.zea7ot.leetcode.ood.lvl3.lc0528

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import kotlin.random.Random

@Suppress(UNUSED)
class SolutionApproach0BinarySearch(weights: IntArray) {
    private val nWeights = weights.size
    private val weightSums = weights.copyOf()

    init {
        for (idx in 1 until nWeights) {
            weightSums[idx] += weightSums[idx - 1]
        }
    }

    fun pickIndex(): Int {
        val idx = Random.nextInt(weightSums[nWeights - 1]) + 1

        var lo = 0
        var hi = nWeights

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            when {
                weightSums[mid] < idx -> lo = mid + 1
                weightSums[mid] > idx -> hi = mid
                else -> return mid
            }
        }

        return lo
    }
}