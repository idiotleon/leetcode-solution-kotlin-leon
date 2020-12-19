/**
 * https://leetcode.com/problems/escape-a-large-maze/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/escape-a-large-maze/discuss/282849/Python-BFS-and-DFS-Maximum-Blocked-19900/303353
 *  https://leetcode.com/problems/escape-a-large-maze/discuss/282849/Python-BFS-and-DFS-Maximum-Blocked-19900
 */
package com.zea7ot.leetcode.lvl5.lc1036

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
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

        return bfs(source, target, blocks) && bfs(target, source, blocks)
    }

    private fun bfs(source: IntArray, target: IntArray, blocks: HashSet<String>): Boolean {
        val seen = HashSet<String>()
        seen.add(hash(source[0], source[1]));

        val queue = LinkedList<IntArray>()
        queue.offer(source)

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()
                val row = cur[0]
                val col = cur[1]

                for (d in 0 until 4) {
                    val nextRow = row + DIRS[d]
                    val nextCol = col + DIRS[d + 1]
                    if (nextRow < 0 || nextCol < 0 || nextRow >= LIMIT || nextCol >= LIMIT) continue

                    val hash = hash(nextRow, nextCol)
                    if (seen.contains(hash) || blocks.contains(hash)) continue
                    if (nextRow == target[0] && nextCol == target[1]) return true

                    queue.offer(intArrayOf(nextRow, nextCol))
                    seen.add(hash(nextRow, nextCol))
                }

                if (seen.size == MAX_VISITS) return true
            }
        }

        return false
    }

    private fun hash(row: Int, col: Int): String = "$row#$col"
}