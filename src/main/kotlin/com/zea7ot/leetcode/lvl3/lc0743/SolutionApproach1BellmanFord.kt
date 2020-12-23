/**
 * https://leetcode.com/problems/network-delay-time/
 *
 * Time Complexity:     O(V * E) ~ O(`nVertices` * `nTimes`)
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode-cn.com/problems/network-delay-time/solution/dan-yuan-zui-duan-lu-po-su-de-dijkstra-dui-you-hua/
 */
package com.zea7ot.leetcode.lvl3.lc0743

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1BellmanFord {
    private companion object {
        private const val DATA_RANGE = 100 + 1
    }

    fun networkDelayTime(times: Array<IntArray>, nVertices: Int, initial: Int): Int {
        val distances = IntArray(nVertices) { DATA_RANGE }.also { it[initial - 1] = 0 }
        var prevDistances: IntArray

        for (idx in 0 until nVertices) {
            prevDistances = distances

            for ((start, end, time) in times) {
                distances[end - 1] = minOf(distances[end - 1], prevDistances[start - 1] + time)
            }
        }

        val shortest = distances.max()!!
        return if (shortest == DATA_RANGE) -1 else shortest
    }
}