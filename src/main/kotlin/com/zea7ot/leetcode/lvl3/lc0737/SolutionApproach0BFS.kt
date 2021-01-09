/**
 * https://leetcode.com/problems/sentence-similarity-ii/
 *
 * Time Complexity:     O(V + E) ~ O(`nWords1` + `nWords2` + `nPairs`)
 * Space Complexity:    O(V + E) ~ O(`nWords1` + `nWords2` + `nPairs`)
 *
 * References:
 *  https://leetcode.com/problems/sentence-similarity/discuss/109633/Java-Super-Clean-Code-(Similarity-I-and-II)
 */
package com.zea7ot.leetcode.lvl3.lc0737

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun areSentencesSimilarTwo(words1: Array<String>, words2: Array<String>, pairs: List<List<String>>): Boolean {
        val nWords1 = words1.size
        val nWords2 = words2.size

        // not used
        // val nPairs = pairs.size

        if (nWords1 != nWords2) return false

        val graph = HashMap<String, HashSet<String>>()
        for ((u, v) in pairs) {
            graph.getOrPut(u) { HashSet() }.add(v)
            graph.getOrPut(v) { HashSet() }.add(u)
        }

        for (idx in words1.indices) {
            val word1 = words1[idx]
            val word2 = words2[idx]

            if (word1 == word2) continue

            if (!graph.containsKey(word1)) return false

            // bfs
            if (!bfs(word1, word2, graph)) return false
        }

        return true
    }

    private fun bfs(
        source: String,
        destination: String,
        graph: HashMap<String, HashSet<String>>
    ): Boolean {
        val queue = LinkedList<String>().also {
            it.offer(source)
        }

        val seen = HashSet<String>().also {
            it.add(source)
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                if (cur == destination) return true

                for (next in graph[cur]!!) {
                    if (!seen.add(next)) continue
                    queue.offer(next)
                }
            }
        }

        return false
    }
}