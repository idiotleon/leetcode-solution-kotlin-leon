/**
 * https://leetcode.com/problems/freedom-trail/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/freedom-trail/discuss/98916/Super-clear-DFS-+-memorization-solution/144638
 *  https://leetcode.com/problems/freedom-trail/discuss/98916/Super-clear-DFS-%2B-memorization-solution
 */
package com.zea7ot.leetcode.lvl4.lc0514

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo1 {
    fun findRotateSteps(ring: String, key: String): Int {
        val memo = HashMap<String, Int>()
        return dfs(0, key, ring, memo)
    }

    private fun dfs(idxKey: Int, key: String, ring: String, memo: HashMap<String, Int>): Int {
        val lenK = key.length
        val lenR = ring.length
        if (idxKey == lenK) return 0

        val ch = key[idxKey]
        val hash = ring + idxKey
        memo[hash]?.let { return it }

        var minSteps = Int.MAX_VALUE
        val firstIdx = ring.indexOf(ch)
        val lastIdx = ring.lastIndexOf(ch)
        for (idx in intArrayOf(firstIdx, lastIdx)) {
            val newRing = ring.substring(idx) + ring.substring(0, idx)
            val steps = 1 + minOf(idx, lenR - idx) + dfs(1 + idxKey, key, newRing, memo)
            minSteps = minOf(minSteps, steps)
        }

        memo[hash] = minSteps
        return minSteps
    }
}