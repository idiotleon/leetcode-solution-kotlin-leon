/**
 * https://leetcode.com/problems/escape-a-large-maze/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/escape-a-large-maze/discuss/282849/Python-BFS-and-DFS-Maximum-Blocked-19900/269098
 *  https://leetcode.com/problems/escape-a-large-maze/discuss/282889/My-Java-DFS-Solution-with-Some-Thoughts-(Triangle-v.s.-14-Circle-in-Pixels)/269264
 */
package com.zea7ot.leetcode.lvl5.lc1036

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private val DIRS = arrayOf(0, -1, 0, 1, 0)
        private const val LIMIT = 1e6.toInt()

        private const val MAX_VISITS = 2e4.toInt()
    }

    fun isEscapePossible(blocked: Array<IntArray>, source: IntArray, target: IntArray): Boolean {
        val blocks = HashSet<String>()
        for (block in blocked) {
            blocks.add(hash(block[0], block[1]))
        }

        // cannot share the same `seen` HashSet
        val seen1 = HashSet<String>()
        val seen2 = HashSet<String>()

        return dfs(source, target, seen1, blocks) && dfs(target, source, seen2, blocks)
    }

    private fun dfs(
        source: IntArray,
        target: IntArray,
        seen: HashSet<String>,
        blocked: Set<String>
    ): Boolean {
        if (source.contentEquals(target) || seen.size >= MAX_VISITS) return true

        for (d in 0 until 4) {
            val nextRow = source[0] + DIRS[d]
            val nextCol = source[1] + DIRS[d + 1]

            val hash = hash(nextRow, nextCol)
            if (nextRow < 0 || nextCol < 0 || nextRow >= LIMIT || nextCol >= LIMIT || blocked.contains(hash) || !seen.add(
                    hash
                )
            ) continue
            if (dfs(intArrayOf(nextRow, nextCol), target, seen, blocked)) return true
        }

        return false
    }

    private fun hash(row: Int, col: Int): String = "$row#$col"
}