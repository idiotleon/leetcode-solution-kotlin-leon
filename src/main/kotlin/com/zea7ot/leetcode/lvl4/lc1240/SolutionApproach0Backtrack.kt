/**
 * https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/discuss/414260/8ms-Memorized-Backtrack-Solution-without-special-case!
 *  https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/discuss/414804/A-Review%3A-Why-This-Problem-Is-a-Tip-of-the-Iceberg
 *  https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/discuss/414979/Java-back-tracking-solution
 */
package com.zea7ot.leetcode.lvl4.lc1240

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private val map = HashMap<Long, Int>()
    private var fewest = Int.MAX_VALUE

    fun tilingRectangle(n: Int, m: Int): Int {
        if (n == m) return 1
        if (n > m) return tilingRectangle(m, n)
        val heights = IntArray(n) { 0 }
        dfs(n, m, heights, 0)
        return fewest
    }

    private fun dfs(n: Int, m: Int, heights: IntArray, cnt: Int) {
        if (cnt >= fewest) return
        var idxShortest = -1
        var shortest = Int.MAX_VALUE
        var key = 0L
        var base = 1L
        for (idx in 0 until n) {
            key += heights[idx] * base
            base *= m + 1

            if (heights[idx] < shortest) {
                idxShortest = idx
                shortest = heights[idx]
            }
        }

        if (shortest == m) {
            fewest = minOf(fewest, cnt)
            return
        }

        map[key]?.let { if (it <= cnt) return }
        map[key] = cnt
        var idxEnd = idxShortest
        while (idxEnd + 1 < n && heights[idxEnd + 1] == heights[idxShortest] && (idxEnd + 1 - idxShortest + 1 + shortest) <= m) ++idxEnd

        for (idx in idxEnd downTo idxShortest) {
            val next = heights.copyOf()
            for (k in idxShortest..idx) {
                next[k] += idx - idxShortest + 1
            }
            dfs(n, m, next, 1 + cnt)
        }
    }
}