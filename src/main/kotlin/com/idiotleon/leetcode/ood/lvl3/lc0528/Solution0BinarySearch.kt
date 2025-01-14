package com.idiotleon.leetcode.ood.lvl3.lc0528

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.random.Random

/**
 * @author: Leon
 * https://leetcode.com/problems/random-pick-with-weight/
 *
 * Time Complexity:
 * initialization:      O(`nWeights`)
 * `pickIndex()`:       O(lg(`nWeights`))
 *
 * Space Complexity:    O(`nWeights`)
 *
 * Reference:
 * https://leetcode.com/problems/random-pick-with-weight/discuss/154044/Java-accumulated-freq-sum-and-binary-search
 */
@Suppress(UNUSED)
class Solution0BinarySearch(weights: IntArray) {
    private val nWeights = weights.size

    // prefix weight sums
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