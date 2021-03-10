/**
 * https://leetcode.com/problems/word-break/
 *
 * Time Complexity:     O(L ^ 2) + O(N * L) / O(N) ~ O(L ^ 2)
 * Space Complexity:    O(N)
 */
package com.an7one.leetcode.lvl4.lc0139

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        // sanity check
        if (s.isEmpty()) return false

        val wordSet = HashSet(wordDict)

        val queue = LinkedList<String>()
        queue.offer(s)

        val seen = HashSet<String>()
        seen.add(s)

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()
                val len = cur.length

                for (idx in 1..len) {
                    if (!wordSet.contains(cur.substring(0, idx))) continue

                    if (idx == len) return true

                    val sub = cur.substring(idx)
                    if (!seen.add(sub)) continue
                    queue.offer(sub)
                }
            }
        }

        return false
    }
}