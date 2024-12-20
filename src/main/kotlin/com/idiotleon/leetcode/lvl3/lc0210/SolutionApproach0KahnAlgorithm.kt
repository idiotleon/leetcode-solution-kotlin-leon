package com.idiotleon.leetcode.lvl3.lc0210

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/***
 * @author: Leon
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * Time Complexity:     O(`numCourses` + `nPres`)
 * Space Complexity:    O(`numCourses` + `nPres`) / O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0KahnAlgorithm {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        // not used
        // val nPres = prerequisites.size
        val (graph, indegrees) = buildGraph(numCourses, prerequisites)

        val queue = ArrayDeque<Int>(numCourses)
        for ((idx, indegree) in indegrees.withIndex()) {
            if (indegree == 0) {
                queue.addLast(idx)
            }
        }

        val ans = IntArray(numCourses) { 0 }
        var idx = 0

        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            ans[idx++] = cur

            for (pre in graph[cur]) {
                if (--indegrees[pre] == 0) {
                    queue.addLast(pre)
                }
            }
        }

        if (idx < numCourses) {
            return intArrayOf()
        }

        return ans
    }

    private fun buildGraph(numCourses: Int, prerequisites: Array<IntArray>): Res {
        val graph = List(numCourses) { mutableListOf<Int>() }
        val indegrees = IntArray(numCourses) { 0 }
        for ((cur, prev) in prerequisites) {
            graph[prev].add(cur)
            ++indegrees[cur]
        }
        return Res(graph, indegrees)
    }

    private data class Res(val graph: List<List<Int>>, val indegrees: IntArray)
}