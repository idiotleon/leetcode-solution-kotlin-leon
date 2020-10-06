/**
 * https://leetcode.com/problems/word-break/
 *
 * Time Complexity:     O(L ^ 2) + O(N * L) / O(N) ~ O(L ^ 2)
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl4.lc0139

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {

        val wordSet = HashSet(wordDict)
        val seen = HashSet<String>()

        val queue = LinkedList(listOf(s))

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (i in 0 until size) {
                val cur = queue.poll()
                val len = cur.length

                for (j in 1..len) {
                    if (!wordSet.contains(cur.substring(0, j))) continue

                    if (j == len) return true

                    val sub = cur.substring(j)
                    if (!seen.add(sub)) continue

                    queue.offer(sub)
                }
            }
        }

        return false
    }
}