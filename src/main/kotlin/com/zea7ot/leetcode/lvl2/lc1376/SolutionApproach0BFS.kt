/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/533109/Java-BFSDFS-Solutions-Clean-code
 */
package com.zea7ot.leetcode.lvl2.lc1376

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.ArrayList

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun numOfMinutes(n: Int, headID: Int, managers: IntArray, informTimes: IntArray): Int {
        val graph = buildGraph(managers, n)

        val queue = LinkedList<Node>()
        queue.offer(Node(headID, 0))

        var timeNeeded = 0

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (idx in 0 until size) {
                val cur = queue.poll()
                val mgr = cur.manager
                val informTime = cur.informTime

                timeNeeded = maxOf(timeNeeded, informTime)

                for (employee in graph[mgr]) {
                    queue.offer(Node(employee, informTime + informTimes[mgr]))
                }
            }
        }

        return timeNeeded
    }

    private fun buildGraph(managers: IntArray, n: Int): Array<ArrayList<Int>> {
        val graph = Array(n) { arrayListOf<Int>() }
        for (idx in 0 until n) {
            val mgr = managers[idx]

            if (mgr != -1) {
                graph[mgr].add(idx)
            }
        }
        return graph
    }

    private data class Node(val manager: Int, val informTime: Int)
}