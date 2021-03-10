/**
 * @author: Leon
 * https://leetcode.com/problems/flipping-an-image/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 */
package com.an7one.leetcode.lvl2.lc0832

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
        // not used
        // val nRows = image.size
        // val nCols = image[0].size

        for (row in image) {
            reverse(row)
            flip(row)
        }

        return image
    }

    private fun flip(row: IntArray) {
        for (idx in row.indices) {
            row[idx] = if (row[idx] == 1) 0 else 1
        }
    }

    private fun reverse(row: IntArray) {
        var lo = 0
        var hi = row.lastIndex

        while (lo < hi) swap(lo++, hi--, row)
    }

    private fun swap(lo: Int, hi: Int, nums: IntArray) {
        val temp = nums[lo]
        nums[lo] = nums[hi]
        nums[hi] = temp
    }
}