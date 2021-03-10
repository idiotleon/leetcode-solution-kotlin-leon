/**
 * this solution is NOT yet correct
 * https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.an7one.leetcode.lvl4.lc1697

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach9DFSMemo {
    fun distanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
        val nQueries = queries.size
        val ans = BooleanArray(nQueries) { false }

        val mst = kruskal(n, edgeList)

        var idx = 0
        val memo = HashMap<Int, HashMap<Int, Boolean>>()
        for ((start, destination, limit) in queries) {
            val seen = HashSet<Int>().also { it.add(start) }
            ans[idx++] = dfs(start, seen, destination, limit, memo, mst)
        }

        return ans
    }

    // to DFS
    private fun dfs(
        cur: Int,
        seen: HashSet<Int>,
        destination: Int,
        limit: Int,
        memo: HashMap<Int, HashMap<Int, Boolean>>,
        mst: HashMap<Int, HashMap<Int, Int>>
    ): Boolean {
        if (cur == destination) return true
        // memo.getOrPut(cur) { hashMapOf() }[destination]?.let { return it }
        memo[cur]?.get(destination)?.let { return it }

        for ((next, distance) in mst[cur] ?: hashMapOf()) {
            if (distance >= limit) continue
            if (seen.add(next) && dfs(next, seen, destination, limit, memo, mst)) {
                memo.getOrPut(next) { hashMapOf() }[destination] = true
                return true
            }
        }

        memo.getOrPut(cur) { hashMapOf() }[destination] = false
        return false
    }

    // to generate the MST
    private fun kruskal(nVertices: Int, edgeList: Array<IntArray>): HashMap<Int, HashMap<Int, Int>> {
        val mst = HashMap<Int, HashMap<Int, Int>>()

        val minHeap = PriorityQueue<Edge>(compareBy { it.distance })
        for ((u, v, distance) in edgeList) {
            minHeap.offer(Edge(u, v, distance))
        }

        var nConnected = 0
        val seen = HashSet<Int>()
        while (minHeap.isNotEmpty()) {
            val (u, v, distance) = minHeap.poll()

            mst.getOrPut(u) { hashMapOf() }.getOrPut(v) { distance }
            mst.getOrPut(v) { hashMapOf() }.getOrPut(u) { distance }

            if (seen.add(u))
                if (nConnected++ == nVertices) break
            if (seen.add(v))
                if (nConnected++ == nVertices) break
        }

        return mst
    }

    private data class Edge(val vertex1: Int, val vertex2: Int, val distance: Int)
}