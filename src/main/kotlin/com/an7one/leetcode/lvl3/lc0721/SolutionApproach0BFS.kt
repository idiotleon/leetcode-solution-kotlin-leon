/**
 * https://leetcode.com/problems/accounts-merge/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC++-Union-Find/241144
 */
package com.an7one.leetcode.lvl3.lc0721

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val graph = HashMap<String, HashSet<String>>()
        val emailToName = HashMap<String, String>()

        for (account in accounts) {
            val name = account[0]
            val size = account.size

            for (idx in 1 until size) {
                graph.getOrPut(account[idx]) { HashSet() }
                emailToName[account[idx]] = name

                if (idx > 1) {
                    val u = account[idx - 1]
                    val v = account[idx]
                    graph.getOrPut(u) { HashSet() }.add(v)
                    graph.getOrPut(v) { HashSet() }.add(u)
                }
            }
        }

        val ans = mutableListOf<List<String>>()
        val seen = HashSet<String>()
        for ((email, _) in graph) {
            if (!seen.add(email)) continue
            val res = bfs(email, seen, graph)
            res.sort()
            res.add(0, emailToName[res[0]]!!)
            ans.add(res)
        }

        return ans
    }

    private fun bfs(
        start: String,
        seen: HashSet<String>,
        graph: HashMap<String, HashSet<String>>
    ): MutableList<String> {
        val res = mutableListOf<String>()

        val queue = LinkedList<String>().also {
            it.offer(start)
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()
                res.add(cur)

                for (next in graph[cur]!!) {
                    if (!seen.add(next)) continue
                    queue.offer(next)
                }
            }
        }

        return res
    }
}