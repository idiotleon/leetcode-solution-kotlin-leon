package com.idiotleon.leetcode.lvl3.lc0841

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

/**
 * @author: Leon
 * https://leetcode.com/problems/keys-and-rooms/
 *
 * Time Complexity:     O(`nRooms` + edges)
 * Space Complexity:    O(`nRooms` + edges)
 *
 * Reference:
 * https://leetcode.com/problems/keys-and-rooms/discuss/133944/Java-8-lines
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        // not used
        // val nRooms = rooms.size

        val queue = ArrayDeque<Int>().also { it.addLast(0) }
        val seen = HashSet<Int>().also { it.add(0) }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()

                for (next in rooms[cur]) {
                    if (seen.add(next)) queue.addLast(next)
                }
            }
        }

        return seen.size == rooms.size
    }
}