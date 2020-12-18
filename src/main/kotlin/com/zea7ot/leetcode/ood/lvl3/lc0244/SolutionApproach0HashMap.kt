/**
 * https://leetcode.com/problems/shortest-word-distance-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/shortest-word-distance-ii/discuss/67028/Java-Solution-using-HashMap/69064
 *  https://leetcode.com/problems/shortest-word-distance-ii/discuss/67028/Java-Solution-using-HashMap
 */
package com.zea7ot.leetcode.ood.lvl3.lc0244

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0HashMap(words: Array<String>) {
    private val strToIdx = HashMap<String, MutableList<Int>>()

    init {
        for (idx in words.indices) {
            strToIdx.getOrPut(words[idx]) { mutableListOf() }.add(idx)
        }
    }

    fun shortest(word1: String, word2: String): Int {
        val idxes1 = strToIdx[word1]!!
        val nIdx1 = idxes1.size
        val idxes2 = strToIdx[word2]!!
        val nIdx2 = idxes2.size

        var shortest = Int.MAX_VALUE

        var idx1 = 0
        var idx2 = 0

        while (idx1 < nIdx1 && idx2 < nIdx2) {
            shortest = minOf(shortest, abs(idxes1[idx1] - idxes2[idx2]))

            if (idxes1[idx1] < idxes2[idx2]) {
                ++idx1
            } else {
                ++idx2
            }
        }

        return shortest
    }
}