package com.zea7ot.leetcode.lvl4.lc1548

import java.util.*
import kotlin.collections.ArrayList
import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DijkstraSPF {
    fun mostSimilar(
        n: Int,
        roads: Array<IntArray>,
        names: Array<String>,
        targetPath: Array<String>
    ): List<Int> {
        val nTargets = targetPath.size
        val graph = buildGraph(n, roads)

        val paths = Array(n) { IntArray(nTargets) { 0 } }
        val distances = Array(n) { IntArray(nTargets) { 0 } }
        for (idxCity in 0 until n) {
            distances[idxCity][0] = if (targetPath[0] == names[idxCity]) 0 else 1

            for (idxTarget in 1 until nTargets) {
                distances[idxCity][idxTarget] = Int.MAX_VALUE
            }
        }

        val minHeap = PriorityQueue<Edit>(compareBy({ distances[it.idxCity][it.idxTarget] }, { -it.idxTarget }))
        for (idxCity in 0 until n) {
            minHeap.offer(Edit(idxCity, 0))
        }

        while (minHeap.isNotEmpty()) {
            val (idxCity, idxTarget) = minHeap.poll()
            if (idxTarget == nTargets - 1) break

            val minCost = distances[idxCity][idxTarget]
            for (idxNeiCity in graph[idxCity]) {
                // the edge weight
                val editDistance = if (targetPath[idxTarget + 1] == names[idxNeiCity]) 0 else 1

                val newDistance = minCost + editDistance
                if (distances[idxNeiCity][idxTarget + 1] > newDistance) {
                    distances[idxNeiCity][idxTarget + 1] = newDistance

                    minHeap.offer(Edit(idxNeiCity, idxTarget + 1))

                    paths[idxNeiCity][idxTarget + 1] = idxCity
                }
            }
        }

        // (with all minimum distances calculated)
        // to find the last city that results in the minimum overall distance
        var last = 0
        for (idxCity in 1 until n) {
            if (distances[idxCity][targetPath.lastIndex] < distances[last][targetPath.lastIndex]) {
                last = idxCity
            }
        }

        // to reconstruct the path based the `last` city
        val ans = ArrayList<Int>()
        for (idxTarget in targetPath.indices.reversed()) {
            ans.add(last)
            last = paths[last][idxTarget]
        }
        ans.reverse()

        return ans
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

    private data class Edit(val idxCity: Int, val idxTarget: Int)
}