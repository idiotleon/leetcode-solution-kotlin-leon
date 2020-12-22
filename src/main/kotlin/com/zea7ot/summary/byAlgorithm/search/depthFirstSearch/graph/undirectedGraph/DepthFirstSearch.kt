/**
 * @author: Leon
 *
 * the two typical Depth First Search implementations in synopsis
 */
package com.zea7ot.summary.byAlgorithm.search.depthFirstSearch.graph.undirectedGraph

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DepthFirstSearch {
    /**
     * only to throw previously unvisited `next` into the next level/state,
     *  without throwing previously visited `next` into the next level/state,
     *  and to deal with `cur` on every level/state
     */
    fun dfs(cur: Int, seen: HashSet<Int>, graph: List<List<Int>>) {
        seen.add(cur)
        // to deal with the `cur` here

        for (next in graph[cur]) {
            if (seen.add(next)) {
                // to enter the next state/level
                dfs(next, seen, graph)
            }
        }
    }

    /**
     * to throw every `next` into the next level/state,
     *  and to sanity check `cur` before dealing with `cur` on each level/state
     */
    fun dfs1(cur: Int, seen: HashSet<Int>, graph: List<List<Int>>) {
        // sanity check `cur`
        if (!seen.add(cur)) return

        // to deal with `cur` here


        // to throw every next into the next level/state
        for (next in graph[cur]) {
            dfs(next, seen, graph)
        }
    }
}