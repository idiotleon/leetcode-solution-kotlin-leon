package com.idiotleon.leetcode.lvl3.lc0210

import com.idiotleon.leetcode.util.Constant

/***
 * @author: Leon
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * Time Complexity:     O(`numCourses` + `nPres`)
 * Space Complexity:    O(`numCourses` + `nPres`) / O(1)
 */
@Suppress(Constant.Annotation.UNUSED)
class SolutionApproach0KahnAlgorithm {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        // not used
        // val nPres = prerequisites.size
        val indegrees = IntArray(numCourses) { 0 }
        val graph = buildGraph(numCourses, prerequisites, indegrees)

        val queue = ArrayDeque<Int>()
        for ((idx, indegree) in indegrees.withIndex()) {
            if (indegree == 0) queue.addLast(idx)
        }

        val ans = IntArray(numCourses) { 0 }
        var idx = 0

        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            ans[idx++] = cur

            for (pre in graph[cur]) {
                if (--indegrees[pre] == 0) queue.addLast(pre)
            }
        }

        if (idx < numCourses) return intArrayOf()

        return ans
    }

    private fun buildGraph(
        numCourses: Int, prerequisites: Array<IntArray>, indegrees: IntArray
    ): List<List<Int>> {
        val graph = List(numCourses) { mutableListOf<Int>() }
        for ((cur, prev) in prerequisites) {
            graph[prev].add(cur)
            ++indegrees[cur]
        }
        return graph
    }
}