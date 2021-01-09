/**
 * https://leetcode.com/problems/sentence-similarity-ii/
 *
 * Time Complexity:     O(V + E) ~ O(`nWords1` + `nWords2` + `nPairs`) ~ O(`nWords1` + `nPairs`)
 * Space Complexity:    O(V + E) ~ O(`nWords1` + `nWords2` + `nPairs`) ~ O(`nWords1` + `nPairs`)
 *
 * References:
 *  https://leetcode.com/problems/sentence-similarity/discuss/109633/Java-Super-Clean-Code-(Similarity-I-and-II)
 */
package com.zea7ot.leetcode.lvl3.lc0737

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
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

            val seen = HashSet<String>().also {
                it.add(word1)
            }
            if (!dfs(word1, word2, seen, graph)) return false
        }

        return true
    }

    private fun dfs(
        source: String,
        destination: String,
        seen: HashSet<String>,
        graph: HashMap<String, HashSet<String>>
    ): Boolean {
        if (graph[source]!!.contains(destination)) return true

        for (next in graph[source]!!) {
            if (seen.add(next) && dfs(next, destination, seen, graph))
                return true
        }

        return false
    }
}