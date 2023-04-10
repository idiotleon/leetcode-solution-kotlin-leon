/**
 * https://leetcode.com/problems/rank-transform-of-a-matrix/
 *
 * Time Complexity:     O(`nRows` * `nCols` * lg(`nRows` * `nCols`))
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * References:
 *  https://leetcode.com/problems/rank-transform-of-a-matrix/discuss/909142/Python-Union-Find/744436
 *  https://leetcode.com/problems/rank-transform-of-a-matrix/discuss/909142/Python-Union-Find
 */
package com.idiotleon.leetcode.lvl5.lc1632

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0UnionFind {
    fun matrixRankTransform(matrix: Array<IntArray>): Array<IntArray> {
        val nRows = matrix.size
        val nCols = matrix[0].size

        val prevRanks = IntArray(nRows + nCols) { 0 }

        val numToCoordinates = TreeMap<Int, MutableList<Pair<Int, Int>>>()
        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                numToCoordinates.getOrPut(matrix[row][col]) { mutableListOf() }.add(Pair(row, col))
            }
        }

        for ((_, coordinates) in numToCoordinates) {
            val uf = UnionFind(nRows + nCols)
            val ranks = prevRanks.copyOf()

            for ((row, col) in coordinates) {
                val (rootX, rootY) = uf.union(row, col + nRows)
                ranks[rootY] = maxOf(ranks[rootX], ranks[rootY])
            }

            for ((row, col) in coordinates) {
                val rank = 1 + ranks[uf.find(row)]
                matrix[row][col] = rank
                prevRanks[col + nRows] = rank
                prevRanks[row] = rank
            }
        }

        return matrix
    }

    private class UnionFind(capacity: Int) {
        private val roots = IntArray(capacity) { idx -> idx }
        private val ranks = IntArray(capacity) { 1 }

        fun union(x: Int, y: Int): Pair<Int, Int> {
            val rootX = find(x)
            val rootY = find(y)

            if (rootX == rootY) return Pair(rootX, rootY)

            return if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX
                ++ranks[rootX]

                Pair(rootY, rootX)
            } else {
                roots[rootX] = rootY
                ++ranks[rootY]

                Pair(rootX, rootY)
            }
        }

        fun find(x: Int): Int {
            if (roots[x] != x) {
                roots[x] = find(roots[x])
            }

            return roots[x]
        }
    }
}