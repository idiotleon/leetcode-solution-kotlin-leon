package com.idiotleon.leetcode.lvl3.lc0841

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

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
class SolutionApproach0DFSRecursive {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        // not used
        // val nRooms = rooms.size

        val seen = HashSet<Int>()
        dfs(0, seen, rooms)

        return seen.size == rooms.size
    }

    private fun dfs(cur: Int, seen: HashSet<Int>, graph: List<List<Int>>) {
        seen.add(cur)

        for (next in graph[cur]) {
            if (seen.contains(next)) continue
            dfs(next, seen, graph)
        }
    }
}