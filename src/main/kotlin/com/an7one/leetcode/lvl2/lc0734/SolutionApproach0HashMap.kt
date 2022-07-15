package com.an7one.leetcode.lvl2.lc0734

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/sentence-similarity/
 *
 * Time Complexity:     O(`nWords1`)
 * Space Complexity:    O(`nWords1` + `nWords2`) ~ O(`nWords1`)
 *
 * Reference:
 * https://leetcode.com/problems/sentence-similarity/discuss/109633/Java-Super-Clean-Code-(Similarity-I-and-II)
 */
@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun areSentencesSimilar(
        words1: Array<String>, words2: Array<String>, similarPairs: List<List<String>>
    ): Boolean {
        val nWords1 = words1.size
        val nWords2 = words2.size

        if (nWords1 != nWords2) return false

        val similarityMap = HashMap<String, HashSet<String>>()
        for ((u, v) in similarPairs) {
            similarityMap.getOrPut(u) { HashSet() }.add(v)
            similarityMap.getOrPut(v) { HashSet() }.add(u)
        }

        for (idx in words1.indices) {
            val word1 = words1[idx]
            val word2 = words2[idx]

            if (word1 == word2) continue
            if (!similarityMap.containsKey(word1)) return false
            if (!similarityMap[word1]!!.contains(word2)) return false
        }

        return true
    }
}