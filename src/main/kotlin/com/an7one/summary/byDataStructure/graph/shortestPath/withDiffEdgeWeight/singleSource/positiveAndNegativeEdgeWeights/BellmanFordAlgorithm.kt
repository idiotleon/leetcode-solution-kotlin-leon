/**
 * @author: Leon
 *
 * Pseudocode:
 *  for loop-n
 *      #Relaxation
 *      for all the edges [start, end, weight]
 *          distances[end] = minOf(distance[end], distance[start] + weight)
 *
 * References:
 *  Paid Course: https://www.acwing.com/video/24/
 */
package com.an7one.summary.byDataStructure.graph.shortestPath.withDiffEdgeWeight.singleSource.positiveAndNegativeEdgeWeights

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class BellmanFordAlgorithm {
    private companion object {
        private const val DATA_RANGE = 1e6.toInt()
    }

    fun bellmanFord(edges: Array<Edge>, nVertices: Int, k: Int): Int {
        val nEdges = edges.size

        val distances = IntArray(nVertices) { DATA_RANGE }
        val backup = IntArray(nVertices) { DATA_RANGE }

        for (i in 0 until k) {
            distances.copyInto(backup)

            for (j in 0 until nEdges) {
                val (start, end, weight) = edges[j]
                distances[end] = minOf(distances[end], backup[start] + weight)
            }
        }

        distances[nVertices].let {
            return if (it == DATA_RANGE) -1
            else it
        }
    }

    data class Edge(val start: Int, val end: Int, val weight: Int)
}