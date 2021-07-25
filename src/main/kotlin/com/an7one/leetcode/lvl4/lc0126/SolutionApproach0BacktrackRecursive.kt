/**
 * https://leetcode.com/problems/word-ladder-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 *  https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS/177427
 *  https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS
 */
package com.an7one.leetcode.lvl4.lc0126

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BacktrackRecursive {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val paths = mutableListOf<List<String>>();
        val wordSet = wordList.toHashSet()
        if (!wordSet.contains(endWord))
            return paths

        val graph = HashMap<String, MutableList<String>>()
        var curLevel = HashSet<String>().also {
            it.add(beginWord)
        }

        var found = false

        while (curLevel.isNotEmpty() && !found) {
            wordSet.removeAll(curLevel)
            val nextLevel = HashSet<String>()

            for (word in curLevel) {
                val chs = word.toCharArray()

                for ((idx, chHold) in chs.withIndex()) {
                    for (ch in 'a'..'z') {
                        chs[idx] = ch
                        val newWord = String(chs)
                        if (!wordSet.contains(newWord))
                            continue

                        graph.getOrPut(word) { mutableListOf() }.add(newWord)
                        nextLevel.add(newWord)
                        if (newWord == endWord)
                            found = true
                    }
                    chs[idx] = chHold
                }

                curLevel = nextLevel
            }
        }

        if (!found)
            return paths

        val path = mutableListOf(beginWord)
        backtrack(beginWord, endWord, graph, path, paths)
        return paths
    }

    private fun backtrack(
        start: String,
        end: String,
        graph: HashMap<String, MutableList<String>>,
        path: MutableList<String>,
        paths: MutableList<List<String>>
    ) {
        if (end == start) {
            paths.add(path.toList())
            return
        }

        graph[start]?.let {
            for (next in it) {
                path.add(next)
                backtrack(next, end, graph, path, paths)
                path.removeAt(path.size - 1)
            }
        }
    }
}