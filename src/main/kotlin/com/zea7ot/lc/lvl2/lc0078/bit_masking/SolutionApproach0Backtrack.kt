/**
 * https://leetcode.com/problems/subsets/
 *
 * Time Complexity:     O(N * (2 ^ N))
 * Space Complexity:    O(N * (2 ^ N))
 *
 * either `(i & (1 << j)) != 0` or `(i & (1 << j)) == 0`, but the actual paths are different
 *
 * References:
 *  https://leetcode.com/problems/subsets/discuss/27288/My-solution-using-bit-manipulation/26405
 *  https://www.mathsisfun.com/sets/power-set.html
 *  https://leetcode.com/problems/subsets/discuss/27288/My-solution-using-bit-manipulation
 */
package com.zea7ot.lc.lvl2.lc0078.bit_masking

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun subsets(nums: IntArray): List<List<Int>> {
        val paths: MutableList<MutableList<Int>> = ArrayList()
        // sanity check
        if (nums.isEmpty()) return paths

        val sizeN = nums.size
        val totalNum = 1 shl sizeN

        for (i in 0 until totalNum) {
            val path = arrayListOf<Int>()

            for (j in 0 until sizeN) {
                if ((i and (1 shl j)) != 0) {
                    path.add(nums[j])
                }
            }

            paths.add(path)
        }

        return paths
    }
}