/**
 * @author: Leon
 * https://leetcode.com/problems/jump-game-iii/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 */
package com.zea7ot.leetcode.lvl3.lc1306

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFS {
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