/**
 * https://leetcode.com/problems/keys-and-rooms/
 *
 * Time Complexity:     O(`nRooms` + edges)
 * Space Complexity:    O(`nRooms` + edges)
 *
 * References:
 *  https://leetcode.com/problems/keys-and-rooms/discuss/133944/Java-8-lines
 */
package com.zea7ot.leetcode.lvl3.lc0841

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        // not used
        // val nRooms = rooms.size

        val queue = LinkedList<Int>().also { it.offer(0) }
        val seen = HashSet<Int>().also { it.add(0) }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                for (next in rooms[cur]) {
                    if (seen.add(next)) {
                        queue.offer(next)
                    }
                }
            }
        }

        return seen.size == rooms.size
    }
}