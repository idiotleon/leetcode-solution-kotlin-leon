/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/discuss/197668/Count-the-Number-of-Islands-O(N)/285615
 *  https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/discuss/197668/Count-the-Number-of-Islands-O(N)
 */
package com.idiotleon.leetcode.lvl4.lc0947

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun removeStones(stones: Array<IntArray>): Int {
        val nStones = stones.size

        var count = 0
        val seen = HashSet<String>()

        for ((row, col) in stones) {
            if (seen.add(hash(row, col))) {
                ++count
                dfs(row, col, seen, stones)
            }
        }

        return nStones - count
    }

    private fun dfs(
        row: Int,
        col: Int,
        seen: HashSet<String>,
        stones: Array<IntArray>
    ) {

        for ((nextRow, nextCol) in stones) {
            if ((row == nextRow || col == nextCol) && seen.add(hash(nextRow, nextCol))) {
                dfs(nextRow, nextCol, seen, stones)
            }
        }
    }

    private fun hash(row: Int, col: Int) = "$row#$col"
}