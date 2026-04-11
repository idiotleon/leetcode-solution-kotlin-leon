package com.idiotleon.leetcode.lvl2.lc3741

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/solutions/7849998/100-beat-2-approaches-map-based-optimize-fuw6
 */
@Suppress(UNUSED)
class Solution0HashMap {
    private companion object {
        private const val IMPL = Int.MAX_VALUE
    }

    fun minimumDistance(nums: IntArray): Int {
        val nNums = nums.size
        val tempMap = HashMap<Int, MutableList<Int>>(nNums)
        for ((idx, num) in nums.withIndex()) {
            tempMap.getOrPut(num) { mutableListOf() }.add(idx)
        }
        val numToIndices: Map<Int, List<Int>> = tempMap.mapValues { it.value.toList() }

        var minDistance = IMPL
        for (indices in numToIndices.values) {
            val size = indices.size

            if (size > 2) {
                for (idx in 0 until size - 2) {
                    val a = indices[idx]
                    val c = indices[idx + 2]
                    val distance = 2 * (c - a)
                    minDistance = minOf(minDistance, distance)
                }
            }
        }
        return if (minDistance == IMPL) -1 else minDistance
    }
}