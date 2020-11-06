/**
 * https://leetcode.com/problems/the-most-similar-path-in-a-graph/
 *
 * Time Complexity:     O(`n` + `nRoads`)
 * Space Complexity:    O(`n` * max(`n`, `nRoads`))
 *
 * References:
 *  https://leetcode.com/problems/the-most-similar-path-in-a-graph/discuss/791155/Java-Clean-Code-w-Comments-and-Video-Explanation.
 */
package com.zea7ot.leetcode.lvl4.lc1548

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun mostSimilar(n: Int,
                    roads: Array<IntArray>,
                    names: Array<String>,
                    targetPath: Array<String>): List<Int> {
        val nTargets = targetPath.size
        val graph = buildGraph(n, roads)

        // the memoization, to keep track of minimum distances
        val distances = Array(n) { Array<Int?>(nTargets) { null } }
        // for reconstructing paths purpose, if all minimum distances have been found
        val paths = Array(n) { IntArray(nTargets) { 0 } }

        var minDistance = Int.MAX_VALUE
        // (with all minimum distances calculated)
        // to find the last city that results in the minimum overall distance
        var lastCity = 0
        for (idxCity in names.indices) {
            val distance = dfs(idxCity, 0, distances, paths, names, targetPath, graph)
            if (distance < minDistance) {
                minDistance = distance
                lastCity = idxCity
            }
        }

        val ans = ArrayList<Int>()
        for (idxTarget in targetPath.indices) {
            ans.add(lastCity)
            lastCity = paths[lastCity][idxTarget]
        }

        return ans
    }

    private fun dfs(idxCity: Int,
                    idxTarget: Int,
                    distances: Array<Array<Int?>>, // memo
                    paths: Array<IntArray>,
                    names: Array<String>,
                    targetPath: Array<String>,
                    graph: Array<ArrayList<Int>>): Int {

        distances[idxCity][idxTarget]?.let { return it }

        var editDistance = if (names[idxCity] == targetPath[idxTarget]) 0 else 1

        if (idxTarget == targetPath.lastIndex) return editDistance

        var minDistance = Int.MAX_VALUE
        for (idxNeiCity in graph[idxCity]) {
            val neiDistance = dfs(idxNeiCity, 1 + idxTarget, distances, paths, names, targetPath, graph)
            if (neiDistance < minDistance) {
                minDistance = neiDistance
                paths[idxCity][idxTarget] = idxNeiCity
            }
        }

        editDistance += minDistance
        distances[idxCity][idxTarget] = editDistance
        return editDistance
    }

    private fun buildGraph(n: Int, roads: Array<IntArray>): Array<ArrayList<Int>> {
        val graph = Array(n) { ArrayList<Int>() }

        for (road in roads) {
            val (u, v) = road

            graph[u].add(v)
            graph[v].add(u)
        }

        return graph
    }
}