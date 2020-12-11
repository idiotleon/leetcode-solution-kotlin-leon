/**
 * https://leetcode.com/problems/kill-process/
 *
 * Time Complexity:     O(`nIDs`)
 * Space Complexity:    O(`nIDs`)
 */
package com.zea7ot.leetcode.lvl3.lc0582

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashMap

@Suppress(UNUSED)
private class SolutionApproach0BFS {
    fun killProcess(pid: List<Int>, ppid: List<Int>, kill: Int): List<Int> {
        // not used
        // val nIDs = pid.size

        val ans = mutableListOf<Int>()
        val graph = buildGraph(pid, ppid)

        val queue = LinkedList<Int>().also { it.offer(kill) }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()
                ans.add(cur)

                graph[cur]?.let {
                    for (next in it) {
                        queue.offer(next)
                    }
                }
            }
        }


        return ans
    }

    private fun buildGraph(pid: List<Int>, ppid: List<Int>): HashMap<Int, MutableList<Int>> {
        val graph = HashMap<Int, MutableList<Int>>()

        for (idx in pid.indices) {
            val parentId = ppid[idx]
            val childId = pid[idx]

            graph.getOrPut(parentId) { mutableListOf() }.add(childId)
        }

        return graph
    }
}