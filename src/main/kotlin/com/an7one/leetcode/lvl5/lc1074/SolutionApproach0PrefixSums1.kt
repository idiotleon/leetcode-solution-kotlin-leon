/**
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
 *
 * Time Complexity:     O(`nRows` * (`nCols` ^ 2))
 * Space Complexity:    O(`nCols`)
 *
 * References:
 *  https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/discuss/303750/JavaC%2B%2BPython-Find-the-Subarray-with-Target-Sum
 */
package com.an7one.leetcode.lvl5.lc1074

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums1 {
    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        // not used
        // val nRows = matrix.size
        val nCols = matrix[0].size

        val prefixSums = matrix.clone().also {
            for (row in it) {
                for (colIdx in 1 until nCols) {
                    row[colIdx] += row[colIdx - 1]
                }
            }
        }

        val sumToFreq = HashMap<Int, Int>()
        var count = 0

        for (lo in 0 until nCols) {
            for (hi in lo until nCols) {
                sumToFreq.clear()

                // #LC0560
                sumToFreq[0] = 1

                // running sum
                var sum = 0
                for (row in prefixSums) {
                    sum += row[hi] - (if (lo > 0) row[lo - 1] else 0)
                    count += sumToFreq[sum - target] ?: 0
                    sumToFreq[sum] = 1 + (sumToFreq[sum] ?: 0)
                }
            }
        }

        return count
    }
}