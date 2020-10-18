/**
 * @author: Leon
 * https://leetcode.com/problems/jump-game-iii/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 */
package com.zea7ot.leetcode.lvl3.lc1306

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFS1 {
    fun canReach(nums: IntArray, start: Int): Boolean {
        val totalNums = nums.size

        val visited = BooleanArray(totalNums) { false }
        return dfs(start, visited, nums)
    }

    private fun dfs(cur: Int, visited: BooleanArray, nums: IntArray): Boolean {
        val totalNums = nums.size
        if (cur < 0 || cur >= totalNums || visited[cur]) return false
        if (nums[cur] == 0) return true
        visited[cur] = true

        for (next in arrayOf(cur + nums[cur], cur - nums[cur])) {
            if (dfs(next, visited, nums)) return true
        }

        return false
    }
}