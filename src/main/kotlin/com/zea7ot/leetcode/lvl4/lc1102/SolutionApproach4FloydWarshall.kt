/**
 * this solution is NOT yet correct.
 * Because I am unable to build the graph with correct edge weights
 *
 * https://leetcode.com/problems/path-with-maximum-minimum-value/
 *
 * Time Complexity:     (`totalVertices` ^ 3)
 * Space Complexity:    (`totalVertices`)
 *
 * the essence of Floyd-Warshall Algorithm:
 *  A(k)[i, j] = min{A(k - 1)[i, j], A(k - 1)[i, k] + A(k - 1)[k, j]}
 *
 * References:
 *  https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
 *  https://www.programiz.com/dsa/floyd-warshall-algorithm
 *  https://youtu.be/oNI0rf2P9gE
 *  https://zxi.mytechroad.com/blog/graph/leetcode-1631-path-with-minimum-effort/
 */
package com.zea7ot.leetcode.lvl4.lc1102

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach4FloydWarshall {
    fun maximumMinimumPath(nums: Array<IntArray>): Int {
        val totalRows = nums.size
        val totalCols = nums[0].size

        val totalVertices = totalRows * totalCols

        val graph = Array(totalVertices) { IntArray(totalVertices) { -1 } }
        for (vertex1 in 0 until totalVertices) {
            for (vertex2 in 0 until totalVertices) {
                val row1 = vertex1 / totalCols
                val col1 = vertex1 % totalCols

                val row2 = vertex2 / totalCols
                val col2 = vertex2 % totalCols

                graph[hash(row1, col1, totalCols)][hash(row2, col2, totalCols)] =
                    minOf(nums[row1][col1], nums[row2][col2])
            }
        }

        val distances = graph.copyOf()

        for (k in 0 until totalVertices)
            for (vertex1 in 0 until totalVertices)
                for (vertex2 in 0 until totalVertices) {
                    if (distances[vertex1][k] + distances[k][vertex2] > distances[vertex1][vertex2]) {
                        distances[vertex1][vertex2] = distances[vertex1][k] + distances[k][vertex2]
                    }

                    // or equivalently
                    // distances[vertex1][vertex2] = minOf(distances[vertex1][vertex2], distances[vertex1][k] + distances[k][vertex2])
                }

        return distances[totalVertices - 1][totalVertices - 1]
    }

    private fun hash(row: Int, col: Int, totalCols: Int) = row * totalCols + col
}