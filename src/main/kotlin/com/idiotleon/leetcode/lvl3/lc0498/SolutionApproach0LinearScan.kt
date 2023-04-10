package com.idiotleon.leetcode.lvl3.lc0498

import com.idiotleon.leetcode.util.Constant

@Suppress(Constant.Annotation.UNUSED)
class SolutionApproach0LinearScan {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val nRows = mat.size
        val nCols = mat[0].size
        val len = nRows * nCols
        val ans = IntArray(len){ 0 }
        var row = 0
        var col = 0
        var idx = 0
        while(idx < len){
            ans[idx++] = mat[row][col]
            if((row + col) % 2 == 0){
                when{
                    col == nCols - 1 -> ++row
                    row == 0 -> ++col
                    else -> {
                        --row
                        ++col
                    }
                }
            }else{
                when{
                    row == nRows - 1 -> ++col
                    col == 0 -> ++row
                    else -> {
                        ++row
                        --col
                    }
                }
            }
        }
        return ans
    }
}