package com.idiotleon.leetcode.lvl1.lc1762

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/buildings-with-an-ocean-view/
 *
 * Time Complexity:     O(`nHeights`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan1 {
    fun findBuildings(heights: IntArray): IntArray {
        val nHeights = heights.size

        val ans = mutableListOf<Int>()

        var tallest = 0

        for ((idx, height) in heights.withIndex().reversed()) {
            if (height > tallest) {
                ans.add(idx)
                tallest = height
            }
        }

        ans.reverse()

        return ans.toIntArray()
    }
}