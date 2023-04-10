/**
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/satisfiability-of-equality-equations/discuss/271948/Java-Union-Find(100)-and-DFS(98)
 */
package com.idiotleon.leetcode.lvl3.lc0990

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private const val EQUAL = '='
        private const val NOT_EQUAL = '!'
    }

    fun equationsPossible(equations: Array<String>): Boolean {
        val graph = HashMap<Char, HashSet<Char>>()

        for (equation in equations) {
            if (equation[1] == EQUAL) {
                val u = equation[0]
                val v = equation[3]

                graph.getOrPut(u) { hashSetOf() }.add(v)
                graph.getOrPut(v) { hashSetOf() }.add(u)
            }
        }

        for (equation in equations) {
            if (equation[1] == NOT_EQUAL) {
                val u = equation[0]
                val v = equation[3]

                if (u == v) return false

                if (!graph.containsKey(u) || !graph.containsKey(v)) continue
                if (hasConflict(u, v, HashSet(), graph)) return false
            }
        }

        return true
    }

    // `cur` and `nxt` should not be connected
    private fun hasConflict(
        cur: Char,
        nxt: Char,
        seen: HashSet<Char>,
        graph: Map<Char, HashSet<Char>>
    ): Boolean {
        if (cur == nxt) return true
        seen.add(cur)

        graph[cur]?.let {
            for (next in it) {
                if (seen.contains(next)) continue
                if (hasConflict(next, nxt, seen, graph)) return true
            }
        }

        for (next in graph[cur] ?: error("")) {
            if (seen.contains(next)) continue
            if (hasConflict(next, nxt, seen, graph)) return true
        }

        return false
    }
}