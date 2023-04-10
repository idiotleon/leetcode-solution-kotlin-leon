/**
 * References:
 *  Paid Membership Required: https://www.acwing.com/video/11/
 */
package com.idiotleon.summary.byAlgorithm.dynamicProgramming.differenceArray

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DiffArray2Dimen {

    fun createDiffArr(nums: Array<IntArray>): Array<IntArray> {
        val nRows = nums.size
        val nCols = nums[0].size

        val diffArr = Array(nRows) { IntArray(nCols) { 0 } }
        for (row in nums.indices) {
            for (col in nums[row].indices) {
                insert(row, col, row, col, nums[row][col], diffArr)
            }
        }

        return diffArr
    }

    fun updateDiffArr(row1: Int, col1: Int, row2: Int, col2: Int, diff: Int, diffArr: Array<IntArray>) =
        insert(row1, col1, row2, col2, diff, diffArr)

    // ? not complete
    fun retrieveArr(nRows: Int, nCols: Int, diffArr: Array<IntArray>) {
        for (row in 1..nRows) {
            for (col in 1..nCols) {
                diffArr[row][col] += diffArr[row - 1][col] + diffArr[row][col - 1] - diffArr[row - 1][col - 1]
            }
        }
    }

    private fun insert(row1: Int, col1: Int, row2: Int, col2: Int, diff: Int, diffArr: Array<IntArray>) {
        diffArr[row1][col1] += diff
        diffArr[row2 + 1][col1] -= diff
        diffArr[row1][col2 + 1] -= diff
        diffArr[row2 + 1][col2 + 1] += diff
    }
}