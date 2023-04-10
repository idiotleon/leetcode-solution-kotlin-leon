/**
 * @author: Leon
 * https://leetcode.com/problems/jump-game-iii/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 */
package com.idiotleon.leetcode.lvl3.lc1306

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun canReach(nums: IntArray, start: Int): Boolean {
        val seen = hashSetOf(start)
        return dfs(start, seen, nums)
    }

    private fun dfs(cur: Int, seen: HashSet<Int>, nums: IntArray): Boolean {
        val totalNums = nums.size
        if (nums[cur] == 0) return true

        for (next in arrayOf(cur + nums[cur], cur - nums[cur])) {
            if ((next in 0 until totalNums).not() || !seen.add(next)) continue
            if (dfs(next, seen, nums)) return true
        }

        return false
    }
}