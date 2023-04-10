/**
 * https://leetcode.com/problems/kill-process/
 *
 * Time Complexity:     O(`nIDs`)
 * Space Complexity:    O(`nIDs`)
 */
package com.idiotleon.leetcode.lvl3.lc0582

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun killProcess(pid: List<Int>, ppid: List<Int>, kill: Int): List<Int> {
        // not used
        // val nIDs = pid.size

        val ans = mutableListOf<Int>()
        val graph = buildGraph(pid, ppid)

        dfs(kill, graph, ans)

        return ans
    }

    private fun dfs(cur: Int, graph: HashMap<Int, MutableList<Int>>, res: MutableList<Int>) {
        res.add(cur)
        graph[cur]?.let {
            for (next in it) {
                dfs(next, graph, res)
            }
        }
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