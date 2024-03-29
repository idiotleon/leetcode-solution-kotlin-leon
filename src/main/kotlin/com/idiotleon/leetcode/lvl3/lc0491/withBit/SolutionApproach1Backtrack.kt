package com.idiotleon.leetcode.lvl3.lc0491.withBit

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/increasing-subsequences/
 *
 * Time Complexity:     O(`nNums` * (2 ^ `nNums`))
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/increasing-subsequences/discuss/97161/Clean-solution-non-recursion-bit-manipulation
 */
@Suppress(UNUSED)
class SolutionApproach1Backtrack {
    fun findSubsequences(nums: IntArray): List<List<Int>> {
        val nNums = nums.size
        val range = 1 shl nNums

        val paths = HashSet<List<Int>>()

        for (bitMask in 1..range) {
            val path = mutableListOf<Int>()

            for (idx in nums.indices) {
                if ((bitMask and (1 shl idx)) != 0 && (path.isEmpty() || path.last() <= nums[idx])) path.add(nums[idx])
            }

            if (path.size > 1) paths.add(path)
        }

        return paths.toList()
    }
}