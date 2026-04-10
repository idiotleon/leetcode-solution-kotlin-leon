package com.idiotleon.leetcode.lvl2.lc3740

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0HashMap0 {
    private companion object {
        private const val RANGE: Int = 100 + 1
        private const val IMPL = RANGE * 3
    }

    fun minimumDistance(nums: IntArray): Int {
        val nNums = nums.size

        // val numToIndex = Array(nNums){ MutableList<Int>() }.also {
        //     val
        //     for((idx, num) in nums.withIndex()){
        //         it[num].
        //         it[num].add(idx)
        //     }
        // }

        val numToIndex: HashMap<Int, MutableList<Int>> = HashMap<Int, MutableList<Int>>(nNums).also {
            for ((idx, num) in nums.withIndex()) {
                it.getOrPut(num) { mutableListOf() }.add(idx)
            }
        }

        var minDistance = IMPL
        for ((num, indices) in numToIndex) {
            getMinDistance(indices)?.let {
                minDistance = minOf(minDistance, it)
            }
        }

        return if (minDistance == IMPL) -1 else minDistance
    }

    private fun getMinDistance(indices: List<Int>): Int? {
        val nIdx = indices.size
        var minDistance = IMPL
        if (nIdx < 2) {
            return null
        } else {
            for (idx in 0 until nIdx - 2) {
                minDistance = minOf(minDistance, getDistance(indices[idx], indices[idx + 1], indices[idx + 2]))
            }
        }
        return minDistance
    }

    private fun getDistance(idx0: Int, idx1: Int, idx2: Int): Int =
        abs(idx0 - idx1) + abs(idx1 - idx2) + abs(idx0 - idx2)
}