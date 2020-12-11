/**
 * https://leetcode.com/problems/subsets-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O(1) / ?O()
 *
 * References:
 *  https://leetcode.wang/leetCode-90-SubsetsII.html
 */
package com.zea7ot.leetcode.lvl2.lc0090

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Iteration1 {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val nNums = nums.size
        nums.sort()

        val paths = mutableListOf<List<Int>>()
        paths.add(listOf())

        var idx = 0
        while (idx < nNums) {
            var cntDup = 0
            while (idx + 1 < nNums && nums[idx] == nums[idx + 1]) {
                ++cntDup
                ++idx
            }

            val idxPrev = paths.size
            for (idxPath in 0 until idxPrev) {
                val path = paths[idxPath].toMutableList()
                for (cnt in 0..cntDup) {
                    path.add(nums[idx])
                    paths.add(path.toList())
                }
            }

            ++idx
        }

        return paths
    }
}