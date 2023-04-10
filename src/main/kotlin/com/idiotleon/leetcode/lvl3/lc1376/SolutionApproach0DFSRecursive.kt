/**
 * @author: Leon
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(H)
 */
package com.idiotleon.leetcode.lvl3.lc1376

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun numOfMinutes(
        n: Int,
        headID: Int,
        manager: IntArray,
        informTime: IntArray
    ): Int {

        val graph = buildGraph(n, manager)

        val longest = intArrayOf(0)
        dfs(headID, 0, longest, informTime, graph)
        return longest[0]
    }

    private fun dfs(
        cur: Int,
        curTime: Int,
        longest: IntArray,
        informTime: IntArray,
        graph: Array<MutableList<Int>>
    ) {

        val nextTime = curTime + informTime[cur]
        longest[0] = maxOf(longest[0], nextTime)

        for (next in graph[cur]) {
            dfs(next, nextTime, longest, informTime, graph)
        }
    }

    private fun buildGraph(n: Int, manager: IntArray): Array<MutableList<Int>> {
        val graph = Array(n) { mutableListOf<Int>() }

        for (idx in manager.indices) {
            val employee = idx
            val mgr = manager[idx]

            if (mgr != -1) {
                graph[mgr].add(employee)
            }
        }

        return graph
    }
}