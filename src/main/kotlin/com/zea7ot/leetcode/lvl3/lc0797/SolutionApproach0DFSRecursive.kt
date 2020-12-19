/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 * Time Complexity:     O(V + E) ~ O(size + total_elements_of_graph)
 * Space Complexity:    O(V + E) ~ O(size + total_elements_of_graph)
 */
package com.zea7ot.leetcode.lvl3.lc0797

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val ans: MutableList<MutableList<Int>> = arrayListOf()
        val size = graph.size

        dfs(0, mutableListOf(0), graph, size - 1, ans)

        return ans
    }

    private fun dfs(
        cur: Int,
        path: MutableList<Int>,
        graph: Array<IntArray>,
        destination: Int,
        paths: MutableList<MutableList<Int>>
    ) {

        if (cur == destination) {
            paths.add(path.toMutableList())
            return
        }

        for (next in graph[cur]) {
            path.add(next)
            dfs(next, path, graph, destination, paths)
            path.remove(path.last())
        }
    }
}