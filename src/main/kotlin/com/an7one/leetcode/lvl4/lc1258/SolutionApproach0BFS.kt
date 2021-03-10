/**
 * https://leetcode.com/problems/synonymous-sentences/
 *
 * Time Complexity:     O(`nSyn` * L)
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/synonymous-sentences/discuss/430604/Java-BFS-Solution-Picture-Explain-Clean-code
 */
package com.an7one.leetcode.lvl4.lc1258

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun generateSentences(synonyms: List<List<String>>, text: String): List<String> {
        // not used
        // val nSyn = synonyms.size

        val graph = buildGraph(synonyms)

        val queue = LinkedList<String>().also {
            it.offer(text)
        }

        val seen = TreeSet<String>().also {
            it.add(text)
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                val words = cur.split("\\s".toRegex()).toTypedArray()
                for (idx in words.indices) {
                    graph[words[idx]]?.let {
                        for (synonym in it) {
                            words[idx] = synonym
                            val newText = words.joinToString(" ")
                            if (!seen.add(newText)) continue
                            queue.offer(newText)
                        }
                    }
                }
            }
        }

        return seen.toList()
    }

    private fun buildGraph(synonyms: List<List<String>>): HashMap<String, MutableList<String>> {
        val graph = HashMap<String, MutableList<String>>()

        for ((u, v) in synonyms) {
            graph.getOrPut(u) { mutableListOf() }.add(v)
            graph.getOrPut(v) { mutableListOf() }.add(u)
        }

        return graph
    }
}