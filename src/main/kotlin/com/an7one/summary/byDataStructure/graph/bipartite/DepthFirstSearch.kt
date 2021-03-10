/**
 * @author: Leon
 *
 * References:
 *  Paid Course, 107min: https://www.acwing.com/video/25/
 */
package com.an7one.summary.byDataStructure.graph.bipartite

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DepthFirstSearch {
    private companion object {
        private const val COLOR = 7
    }

    fun isGraphBipartite(graph: List<List<Int>>, nVertices: Int): Boolean {
        val colors = Array<Int?>(nVertices) { null }
        return dfs(0, COLOR, colors, graph)
    }

    private fun dfs(cur: Int, curColor: Int, colors: Array<Int?>, graph: List<List<Int>>): Boolean {
        colors[cur]?.let { return it == curColor }

        colors[cur] = curColor

        for (next in graph[cur]) {
            if (!dfs(next, -curColor, colors, graph)) return false
        }

        return true
    }

    private fun dfs1(cur: Int, curColor: Int, colors: Array<Int?>, graph: List<List<Int>>): Boolean {
        colors[cur] = curColor

        for (next in graph[cur]) {
            colors[next]?.let { return it == -curColor }
            if (!dfs1(next, -curColor, colors, graph)) return false
        }

        return true
    }
}