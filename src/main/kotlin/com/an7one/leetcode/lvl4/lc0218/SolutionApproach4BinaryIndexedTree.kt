/**
 * this is NOT yet correct solution
 * https://leetcode.com/problems/the-skyline-problem/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/the-skyline-problem/discuss/61198/My-O(nlogn)-solution-using-Binary-Indexed-Tree(BIT)Fenwick-Tree/62473
 *  https://leetcode.com/problems/the-skyline-problem/discuss/61287/Java-Binary-Indexed-Tree-Solution
 *  https://leetcode.com/problems/the-skyline-problem/discuss/61198/My-O(nlogn)-solution-using-Binary-Indexed-Tree(BIT)Fenwick-Tree
 */
package com.an7one.leetcode.lvl4.lc0218

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach4BinaryIndexedTree {
    private companion object {
        private const val IS_LEFT_EDGE = 1
        private const val IS_RIGHT_EDGE = 2
    }

    fun getSkyline(blds: Array<IntArray>): List<List<Int>> {
        val nBuildings = blds.size

        val buildingEdges = Array<BuildingEdge?>(nBuildings * 2) { null }
        for (idx in blds.indices) {
            val (xCoordLeftEdge, xCoordRightEdge, height) = blds[idx]
            buildingEdges[2 * idx] = BuildingEdge(xCoordLeftEdge, height, IS_LEFT_EDGE, idx)
            buildingEdges[2 * idx + 1] = BuildingEdge(xCoordRightEdge, height, IS_RIGHT_EDGE, idx)
        }
        buildingEdges.sortWith(compareBy({ it!!.height }, { it!!.isLeft }))

        // range compression
        val xCoordToRank = HashMap<Int, Int>()
        var rank = 0
        for (edge in buildingEdges) {
            xCoordToRank[edge!!.xCoord] = ++rank
        }

        val fenwick = BinaryIndexedTree(rank + 1)

        val ans = mutableListOf<MutableList<Int>>()
        var xCoordLeftEdge = 0
        var xCoordRightEdge = 0
        var buildingHeight = 0
        var tallestSoFar = 0

        for (edge in buildingEdges) {
            val (xCoord, height, isLeft, idx) = edge!!

            if (isLeft == IS_LEFT_EDGE) {
                xCoordLeftEdge = xCoord
                xCoordRightEdge = blds[idx][1]
                buildingHeight = height
                fenwick.update(xCoordToRank[xCoordRightEdge]!!, height)
            } else {
                xCoordLeftEdge = blds[idx][1]
            }

            val tallestRightAfter = fenwick.query(xCoordToRank[xCoordLeftEdge]!!)

            if (tallestRightAfter != tallestSoFar) {
                if (ans.isNotEmpty() && ans.last()[0] == xCoordLeftEdge) {
                    val last = ans.last()
                    val curTallest = maxOf(tallestRightAfter, last[1])
                    last[1] = curTallest
                    tallestSoFar = curTallest
                } else {
                    ans.add(mutableListOf(xCoordLeftEdge, tallestRightAfter))
                    tallestSoFar = tallestRightAfter
                }
            }
        }

        return ans
    }

    private class BinaryIndexedTree(private val capacity: Int) {
        private val fenwick = IntArray(capacity) { 0 }

        fun query(index: Int): Int {
            var max = 0
            var idx = index + 1

            while (idx < capacity) {
                max = maxOf(fenwick[idx], max)
                idx += (idx and -idx)
            }

            return max
        }

        fun update(index: Int, value: Int) {
            var idx = index + 1

            while (idx > 0) {
                fenwick[idx] += maxOf(fenwick[idx], value)
                idx -= (idx and -idx)
            }
        }
    }

    private data class BuildingEdge(val xCoord: Int, val height: Int, val isLeft: Int, val idx: Int)
}