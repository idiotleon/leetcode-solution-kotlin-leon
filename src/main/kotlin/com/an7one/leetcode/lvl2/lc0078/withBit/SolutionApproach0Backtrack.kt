package com.an7one.leetcode.lvl2.lc0078.withBit

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/subsets/
 *
 * Time Complexity:     O(`nNums` * (2 ^ nNums)) + O(`nNums` * lg(`nNums`)) ~ O(`nNums` * (`nNums` ^ 2))
 *  `paths.add(path.toMutableList())` costs O(`nNums`)
 *
 * Space Complexity:    O(`nNums` *  (2 ^ `nNums`))
 *
 * either `(bitMask and (1 shl idx)) != 0` or `(bitMask and (1 shl idx)) == 0`,
 *  but the actual paths are different
 *
 *
 * References:
 *  https://leetcode.com/problems/subsets/solution/
 *  https://leetcode.com/problems/subsets/discuss/27288/My-solution-using-bit-manipulation/26405
 *  https://www.mathsisfun.com/sets/power-set.html
 *  https://leetcode.com/problems/subsets/discuss/27288/My-solution-using-bit-manipulation
 */
@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun subsets(nums: IntArray): List<List<Int>> {
        val nNums = nums.size
        val range = 1 shl nNums

        val paths = mutableListOf<MutableList<Int>>()

        for (bitMask in 0 until range) {
            val path = mutableListOf<Int>()

            for (idx in nums.indices) {
                val temp = bitMask and (1 shl idx)
                println("temp:$temp")
                if (bitMask and (1 shl idx) != 0)
                    path.add(nums[idx])
            }

            paths.add(path.toMutableList())
        }

        return paths
    }
}