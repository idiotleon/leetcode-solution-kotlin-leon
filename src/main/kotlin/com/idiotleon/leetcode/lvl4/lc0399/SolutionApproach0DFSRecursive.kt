package com.idiotleon.leetcode.lvl4.lc0399

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/evaluate-division/
 *
 * Time Complexity:
 *  O(`nQueries` * (`nEquations` + 2 * `nValues`)) + O(`nEquations`) ~ O(`nQueries` * (`nEquations` + 2 * `nValues`))
 *      O(`nEquations`), to build up the graph
 *      O(`nQueries` * (`nQueries` + 2 * `nValues`)), to DFS the graph
 *
 * Space Complexity:
 *  O(2 * (`nEquations` + `nValues`)) + O(`nValues`) ~ O(2 * (`nEquations` + `nValues`))
 *      O(2 * (`nEquations` + `nValues`)), to build up the graph
 *      O(`nValues`), for the visited set
 *
 * Reference:
 * https://leetcode.com/problems/evaluate-division/discuss/88169/Java-AC-Solution-using-graph/126499
 * https://leetcode.com/problems/evaluate-division/discuss/171649/1ms-DFS-with-Explanations
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        // not used
        // val nValues = values.size
        // val nQueries = queries.size

        val nEquations = queries.size
        val graph = buildGraph(equations, values)
        val ans = DoubleArray(nEquations) { 0.0 }

        for (idx in ans.indices) {
            val (start, end) = queries[idx]
            val seen = HashSet<String>()
            ans[idx] = dfs(start, end, seen, graph)
        }

        return ans
    }

    private fun dfs(
        start: String, end: String, seen: HashSet<String>, graph: HashMap<String, HashMap<String, Double>>
    ): Double {
        if (!graph.containsKey(start)) return -1.0
        val map = graph[start]!!
        if (map.containsKey(end)) return map[end]!!

        seen.add(start)
        for ((nextStart, nextEnd) in graph[start]!!) {
            if (!seen.contains(nextStart)) {
                val productWeight = dfs(nextStart, end, seen, graph)
                if (productWeight != -1.0) {
                    return nextEnd * productWeight
                }
            }
        }

        return -1.0
    }

    private fun buildGraph(
        equations: List<List<String>>, values: DoubleArray
    ): HashMap<String, HashMap<String, Double>> {
        val graph = HashMap<String, HashMap<String, Double>>()

        for (idx in equations.indices) {
            val (u, v) = equations[idx]
            graph.getOrPut(u) { HashMap() }[v] = values[idx]
            graph.getOrPut(v) { HashMap() }[u] = 1 / values[idx]
        }

        return graph
    }
}