/**
 * @author: Leon
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 * Time Complexity:     O(V + E) ~ O(size + TOTAL_ELEMENTS)
 * Space Complexity:    O(V + E) ~ O(size + TOTAL_ELEMENTS)
 */
package com.zea7ot.leetcode.lvl3.lc0797

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val paths: MutableList<MutableList<Int>> = arrayListOf()
        // sanity check
        if (graph.isEmpty()) return paths

        val size = graph.size
        val destination = size - 1

        val queue = LinkedList<MutableList<Int>>(mutableListOf(mutableListOf(0)))
        // or equivalently
        // queue.offer(mutableListOf(0))

        while (queue.isNotEmpty()) {
            val sizeQ = queue.size

            for (i in 0 until sizeQ) {
                val list = queue.poll()
                val cur = list.last()
                if (cur == destination) {
                    paths.add(list.toMutableList())
                    continue
                }

                for (next in graph[cur]) {
                    val nextList = list.toMutableList().apply { add(next) }
                    // or equivalently
                    // nextList.add(next)
                    queue.offer(nextList)
                }
            }
        }

        return paths
    }
}