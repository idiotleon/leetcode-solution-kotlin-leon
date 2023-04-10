/**
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
 *
 * Time Complexity:     O((`nRows` ^ 2) * `nCols`)
 * Space Complexity:    O(`nRows`)
 *
 * Reference:
 *  https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/discuss/303767/Java-reduce-to-1D-array/884599
 */
package com.idiotleon.leetcode.lvl5.lc1074

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums0 {
    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        val nRows = matrix.size
        val nCols = matrix[0].size

        var freq = 0
        for (rowLo in 0 until nRows) {
            val prefixSums = IntArray(nCols) { 0 }
            for (rowHi in rowLo until nRows) {
                for (col in 0 until nCols) {
                    prefixSums[col] += matrix[rowHi][col]
                }

                freq += numSubarraySumTarget(prefixSums, target)
            }
        }

        return freq
    }

    private fun numSubarraySumTarget(nums: IntArray, target: Int): Int {
        val sumToFreq = hashMapOf(0 to 1)

        var freq = 0
        var sum = 0

        for (num in nums) {
            sum += num
            sumToFreq[sum - target]?.let { freq += it }
            sumToFreq[sum] = 1 + (sumToFreq[sum] ?: 0)
        }

        return freq
    }
}