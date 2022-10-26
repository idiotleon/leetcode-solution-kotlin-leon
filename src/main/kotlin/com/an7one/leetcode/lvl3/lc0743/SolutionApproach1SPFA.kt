package com.an7one.leetcode.lvl3.lc0743

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/network-delay-time/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode-cn.com/problems/network-delay-time/solution/dan-yuan-zui-duan-lu-po-su-de-dijkstra-dui-you-hua/
 */
@Suppress(UNUSED)
class SolutionApproach1SPFA {
    private companion object {
        private const val DATA_RANGE = 100 + 1
    }

    fun networkDelayTime(times: Array<IntArray>, nVertices: Int, initial: Int): Int {
        val graph = buildGraph(times, nVertices)

        val distances = IntArray(nVertices) { DATA_RANGE }.also {
            it[initial - 1] = 0
        }

        val queue = ArrayDeque<Int>().also {
            it.addLast(initial - 1)
        }

        val isInQueue = BooleanArray(nVertices) { false }.also {
            it[initial - 1] = true
        }

        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            isInQueue[cur] = false

            for ((next, time) in graph[cur]) {
                if (distances[next] > distances[cur] + time) {
                    distances[next] = distances[cur] + time
                    if (!isInQueue[next]) {
                        queue.addLast(next)
                        isInQueue[next] = true
                    }
                }
            }
        }

        val ans = distances.maxOrNull()!!
        return if (ans == DATA_RANGE) -1 else ans
    }

    private fun buildGraph(times: Array<IntArray>, nVertices: Int): List<List<State>> {
        val graph = List(nVertices) { mutableListOf<State>() }

        for ((start, end, time) in times) {
            graph[start - 1].add(State(end - 1, time))
        }

        return graph
    }

    private data class State(val vertex: Int, val time: Int)
}