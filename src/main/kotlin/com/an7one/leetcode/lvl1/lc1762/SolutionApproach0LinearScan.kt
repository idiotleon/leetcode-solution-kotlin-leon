/**
 * @author: Leon
 * https://leetcode.com/problems/buildings-with-an-ocean-view/
 *
 * Time Complexity:     O(`nHeights`)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl1.lc1762

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun findBuildings(heights: IntArray): IntArray {
        // not used
        // val nHeights = heights.size

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