/**
 * https://leetcode.com/problems/circular-array-loop/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(lg(`nNums`))
 *
 * to detect if there is any cycle, of length strictly longer than 1,
 *  and in the same direction
 *
 * References:
 *  https://leetcode.com/problems/circular-array-loop/discuss/395670/JAVA-simple-DFS-O(n)-beat-100-time-and-space
 */
package com.an7one.leetcode.lvl4.lc0457

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private const val NOT_VISITED = 0
        private const val VISITING = 1
        private const val VISITED = 2
    }

    fun circularArrayLoop(nums: IntArray): Boolean {
        val nNums = nums.size
        val visited = IntArray(nNums) { NOT_VISITED }
        for (idx in nums.indices) {
            if (visited[idx] != NOT_VISITED) continue
            if (dfs(idx, visited, nums)) return true
        }

        return false
    }

    private fun dfs(cur: Int, visited: IntArray, nums: IntArray): Boolean {
        val nNums = nums.size
        if (visited[cur] == VISITING) return true
        if (visited[cur] == VISITED) return false

        visited[cur] = VISITING

        var next = cur + nums[cur]
        next %= nNums
        if (next < 0) next += nNums

        if (cur == next || nums[cur] * nums[next] < 0) {
            visited[cur] = VISITED
            return false
        }

        if (dfs(next, visited, nums)) return true
        visited[cur] = VISITED
        return false
    }
}