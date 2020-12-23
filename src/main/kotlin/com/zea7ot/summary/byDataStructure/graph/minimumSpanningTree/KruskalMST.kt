/**
 * @author: Leon
 *
 * Time Complexity:     O(E * lg(E))
 * Space Complexity:    O(E)
 *
 * Pseudocode:
 *  1. to sort all edges based on their weights
 *  2. to enumerate each edge [start, end, weight]
 *      if `start` is connected to `end`, to add this edge into the set
 *
 * References:
 *  Paid Course: https://www.acwing.com/video/25/
 */
package com.zea7ot.summary.byDataStructure.graph.minimumSpanningTree

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class KruskalMST {
    fun kruskalMST(edges: Array<Edge>, nVertices: Int): Int {
        // roots for union find
        val roots = IntArray(nVertices) { idx -> idx }

        // or a minHeap
        edges.sortBy { it.weight }

        var minSpan = 0
        var count = 0

        for ((start, end, weight) in edges) {
            val rootStart = find(start, roots)
            val rootEnd = find(end, roots)

            // to union/connect
            if (rootStart != rootEnd) {
                roots[start] = end
                minSpan += weight
                ++count
            }
        }

        // isolated / dislocated
        if (count < nVertices - 1) return -1
        return minSpan
    }

    private fun find(x: Int, roots: IntArray): Int {
        if (x != roots[x]) {
            val root = find(roots[x], roots)
            roots[x] = root
            return root
        }

        return roots[x]
    }

    data class Edge(val start: Int, val end: Int, val weight: Int)
}