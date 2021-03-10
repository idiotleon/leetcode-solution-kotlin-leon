/**
 * https://leetcode.com/problems/subsets-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O(1) / ?O()
 *
 * References:
 *  https://leetcode.com/problems/subsets-ii/discuss/30137/Simple-iterative-solution/556559
 *  https://leetcode.com/problems/subsets-ii/discuss/30137/Simple-iterative-solution
 *  https://leetcode.wang/leetCode-90-SubsetsII.html
 */
package com.an7one.leetcode.lvl2.lc0090

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Iteration {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()

        val paths = mutableListOf<List<Int>>()
        paths.add(listOf())

        var idxPrevStart = 0
        for (idx in nums.indices) {
            val idxCurStart = paths.size
            val idxCopyFrom = if (idx > 0 && nums[idx - 1] == nums[idx]) idxPrevStart else 0

            for (idxCopy in idxCopyFrom until idxCurStart) {
                val path = paths[idxCopy].toMutableList()
                path.add(nums[idx])
                paths.add(path)
            }

            idxPrevStart = idxCurStart
        }

        return paths
    }
}