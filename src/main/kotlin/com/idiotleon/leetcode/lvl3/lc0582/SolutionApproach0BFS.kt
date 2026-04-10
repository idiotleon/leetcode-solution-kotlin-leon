package com.idiotleon.leetcode.lvl3.lc0582

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/kill-process/
 *
 * Time Complexity:     O(`nIDs`)
 * Space Complexity:    O(`nIDs`)
 */
@Suppress(UNUSED)
private class SolutionApproach0BFS {
    fun killProcess(pid: List<Int>, ppid: List<Int>, kill: Int): List<Int> {
        // not used
        // val nIDs = pid.size

        val ans = mutableListOf<Int>()
        val graph = buildGraph(pid, ppid)

        val queue = ArrayDeque<Int>().also { it.addLast(kill) }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()
                ans.add(cur)

                graph[cur]?.let {
                    for (next in it) {
                        queue.addLast(next)
                    }
                }
            }
        }

        return ans
    }

    private fun buildGraph(pid: List<Int>, ppid: List<Int>): Map<Int, List<Int>> {
        val graph = HashMap<Int, MutableList<Int>>()

        for (idx in pid.indices) {
            val parentId = ppid[idx]
            val childId = pid[idx]

            graph.getOrPut(parentId) { mutableListOf() }.add(childId)
        }

        return graph.mapValues { it.value.toList() }
    }
}