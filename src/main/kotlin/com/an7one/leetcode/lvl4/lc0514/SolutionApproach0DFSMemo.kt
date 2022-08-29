package com.an7one.leetcode.lvl4.lc0514

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/freedom-trail/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/freedom-trail/discuss/98897/Java-Clear-Solution-dfs+memoization/103015
 * https://leetcode.com/problems/freedom-trail/discuss/98897/Java-Clear-Solution-dfs%2Bmemoization
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun findRotateSteps(ring: String, key: String): Int {
        val lenR = ring.length
        val lenK = key.length

        val chToIndices = List(26) { HashSet<Int>() }
        for (idx in ring.indices) {
            chToIndices[ring[idx] - 'a'].add(idx)
        }

        val memo = Array(lenK) { Array<Int?>(lenR) { null } }
        return dfs(0, 0, key, ring, chToIndices, memo) + lenK
    }

    private fun dfs(
        idxKey: Int, idxRing: Int, key: String, ring: String, chToIdxes: List<HashSet<Int>>, memo: Array<Array<Int?>>
    ): Int {
        val lenR = ring.length
        val lenK = key.length
        if (idxKey == lenK) return 0

        memo[idxKey][idxRing]?.let { return it }

        var minSteps = Int.MAX_VALUE
        for (nextIdxRing in chToIdxes[key[idxKey] - 'a']) {
            val diff = abs(nextIdxRing - idxRing)
            // to pick clockwise or anti-clockwise, whichever is smaller
            val pick = minOf(diff, lenR - diff)
            val steps = pick + dfs(1 + idxKey, nextIdxRing, key, ring, chToIdxes, memo)
            minSteps = minOf(minSteps, steps)
        }

        memo[idxKey][idxRing] = minSteps
        return minSteps
    }
}