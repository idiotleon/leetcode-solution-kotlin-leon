/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/533109/Java-BFSDFS-Solutions-Clean-code
 *  https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/532560/JavaC%2B%2BPython-DFS
 */
package com.zea7ot.leetcode.lvl2.lc1376

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFS {
    fun numOfMinutes(n: Int, headID: Int, managers: IntArray, informTimes: IntArray): Int {
        val graph = buildGraph(managers, n)
        return dfs(headID, informTimes, graph)
    }

    private fun dfs(manager: Int, informTimes: IntArray, graph: Array<ArrayList<Int>>): Int {
        var max = 0
        for (employee in graph[manager]) {
            max = maxOf(max, dfs(employee, informTimes, graph))
        }
        return max + informTimes[manager]
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
}