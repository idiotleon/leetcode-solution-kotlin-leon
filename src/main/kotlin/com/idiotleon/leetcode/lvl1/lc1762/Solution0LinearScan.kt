package com.idiotleon.leetcode.lvl1.lc1762

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/buildings-with-an-ocean-view/
 *
 * Time Complexity:     O(`nHeights`)
 * Space Complexity:    O(1) / O(`nHeights`)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun findBuildings(heights: IntArray): IntArray {
        val nHeights = heights.size

        val ans = mutableListOf<Int>()
        var tallest = 0

        for (idx in nHeights - 1 downTo 0) {
            if (heights[idx] > tallest) {
                ans.add(idx)
                tallest = heights[idx]
            }
        }

        ans.reverse()

        return ans.toIntArray()
    }
}