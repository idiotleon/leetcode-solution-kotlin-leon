/**
 * https://leetcode.com/problems/maximum-performance-of-a-team/
 *
 * Time Complexity:     O(`n` * lg(`n`)) + O(`n` * lg(`k`))
 * Space Complexity:    O(`n`)
 *
 * Reference:
 * https://leetcode.com/problems/maximum-performance-of-a-team/discuss/539687/JavaC%2B%2BPython-Priority-Queue
 */
package com.an7one.leetcode.lvl4.lc1383

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
        val team = Array(n) { idx -> Node(efficiency[idx], speed[idx]) }.also {
            it.sortBy { n -> -n.efficiency }
        }

        val minHeap = PriorityQueue<Int>()
        var maxPerf = 0L
        var sumSpeed = 0L

        for ((eff, spd) in team) {
            minHeap.add(spd)
            sumSpeed += spd
            if (minHeap.size > k)
                sumSpeed -= minHeap.poll()

            maxPerf = maxOf(maxPerf, sumSpeed * eff)
        }

        return (maxPerf % MOD).toInt()
    }

    private data class Node(val efficiency: Int, val speed: Int)
}