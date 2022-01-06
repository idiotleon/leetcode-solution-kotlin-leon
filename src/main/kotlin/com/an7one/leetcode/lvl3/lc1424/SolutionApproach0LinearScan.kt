package com.an7one.leetcode.lvl3.lc1424

import com.an7one.leetcode.util.Constant

@Suppress(Constant.Annotation.UNUSED)
class SolutionApproach0LinearScan {
    @OptIn(ExperimentalStdlibApi::class)
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        // not used
        // val nRows = nums.size
        // not used
        // val nCols = nums.size
        val idxToNums = HashMap<Int, ArrayDeque<Int>>()
        var count = 0
        for ((row, list) in nums.withIndex()) {
            for ((col, num) in list.withIndex()) {
                val key = row + col
                idxToNums.getOrPut(key) { ArrayDeque() }.addFirst(num)
                ++count
            }
        }
        val ans = IntArray(count){ 0 }
        var idx = 0
        for ((_, values) in idxToNums){
            for(value in values){
                ans[idx++] = value
            }
        }
        return ans
    }
}