package com.idiotleon.leetcode.lvl3.lc0797

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.collections.ArrayDeque

/**
 * @author: Leon
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 * Time Complexity:     O(V + E) ~ O(size + TOTAL_ELEMENTS)
 * Space Complexity:    O(V + E) ~ O(size + TOTAL_ELEMENTS)
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val paths: MutableList<List<Int>> = arrayListOf()
        // sanity check
        if (graph.isEmpty()) return paths

        val size = graph.size
        val destination = size - 1

        val queue = ArrayDeque(mutableListOf(mutableListOf(0)))
        // or equivalently
        // queue.offer(mutableListOf(0))

        while (queue.isNotEmpty()) {
            val sizeQ = queue.size

            for (i in 0 until sizeQ) {
                val list = queue.removeFirst()
                val cur = list.last()
                if (cur == destination) {
                    paths.add(list.toList())
                    continue
                }

                for (next in graph[cur]) {
                    val nextList = list.toMutableList().apply { add(next) }
                    // or equivalently
                    // nextList.add(next)
                    queue.addLast(nextList)
                }
            }
        }

        return paths
    }
}