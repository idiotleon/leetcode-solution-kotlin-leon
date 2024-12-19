package com.idiotleon.leetcode.lvl2.lc0207

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/course-schedule/
 *
 * Time Complexity:     O(`numCourses` + `nPres`)
 * Space Complexity:    O(`numCourses` + `nPres`) / O(1)
 */
@Suppress(UNUSED)
class Solution0KahnAlgorithm {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val (graph, indegrees) = buildGraph(numCourses, prerequisites)

        val queue = ArrayDeque<Int>(numCourses).also {
            for ((idx, indegree) in indegrees.withIndex()) {
                if (indegree == 0) {
                    it.addLast(idx)
                }
            }
        }

        var count = 0
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            ++count

            for (pre in graph[cur]) {
                if (--indegrees[pre] == 0) {
                    queue.addLast(pre)
                }
            }
        }

        return count == numCourses
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