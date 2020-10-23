/**
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
 *
 * Time Complexity:     O(`totalRows` * (`totalCols` ^ 2))
 * Space Complexity:    O(`totalCols`)
 *
 * References:
 *  https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/discuss/303750/JavaC%2B%2BPython-Find-the-Subarray-with-Target-Sum
 */
package com.zea7ot.leetcode.lvl5.lc1074

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums {
    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        // not used
        // val totalRows = matrix.size
        val totalCols = matrix[0].size

        val prefixSums = matrix.clone().also {
            for (row in it) {
                for (colIdx in 1 until totalCols) {
                    row[colIdx] += row[colIdx - 1]
                }
            }
        }

        val freqs = HashMap<Int, Int>()
        var count = 0

        for (lo in 0 until totalCols) {
            for (hi in lo until totalCols) {
                freqs.clear()

                // #LC0560
                freqs[0] = 1

                // running sum
                var sum = 0
                for (row in prefixSums) {
                    sum += row[hi] - (if (lo > 0) row[lo - 1] else 0)
                    count += freqs[sum - target] ?: 0
                    freqs[sum] = 1 + (freqs[sum] ?: 0)
                }
            }
        }

        return count
    }
}