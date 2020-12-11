/**
 * https://leetcode.com/problems/minimize-malware-spread-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/minimize-malware-spread-ii/discuss/184129/python-solution-with-my-thinking-process-(with-extra-Chinese-explanation)/189227
 *  https://leetcode.com/problems/minimize-malware-spread-ii/discuss/184129/python-solution-with-my-thinking-process-(with-extra-Chinese-explanation)
 */
package com.zea7ot.leetcode.lvl4.lc0928

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun minMalwareSpread(graph: Array<IntArray>, initials: IntArray): Int {
        val totalNodes = graph.size

        val map = HashMap<Int, ArrayList<Int>>()
        for (malware in initials) {
            val seen = initials.toHashSet()

            val queue = LinkedList<Int>()
            queue.offer(malware)

            while (queue.isNotEmpty()) {
                val size = queue.size

                for (sz in 0 until size) {
                    val cur = queue.poll()
                    for (next in graph[cur].indices) {
                        if (graph[cur][next] == 1) { // if `cur` and `next` are connected
                            if (seen.contains(next)) continue
                            seen.add(next)
                            queue.offer(next)
                            // to build up the graph/connection
                            // among this `malware` and its directly infected nodes
                            map.getOrPut(next) { arrayListOf() }.add(malware)
                        }
                    }
                }
            }
        }

        // "singly"-infected nodes that can be saved (after removing its "malware")
        val singlyInfected = IntArray(totalNodes) { 0 }
        for ((_, allInfected) in map) {
            if (allInfected.size == 1) { // a node is safe iff it's just directly infected by one malware
                val infectedNode = allInfected[0]
                ++singlyInfected[infectedNode]
            }
        }

        var max = 0
        var removed = -1
        for (idx in singlyInfected.indices) {
            if (singlyInfected[idx] > max) {
                max = singlyInfected[idx]
                removed = idx
            }
        }

        initials.sort()
        return if (removed == -1) initials[0] else removed


        // or equivalently
        /*
            var max = 0
            // "singly"-infected nodes that can be saved (after removing its "malware")
            val singlyInfected = IntArray(totalNodes) { 0 }
            for ((_, allInfected) in map) {
                if (allInfected.size == 1) { // a node is safe iff it's just directly infected by one malware
                    val infectedNode = allInfected[0]
                    max = maxOf(max, ++singlyInfected[infectedNode])
                }
            }

            initials.sort()
            return if (max == 0) initials[0] else singlyInfected.indexOf(max)
        */
    }
}