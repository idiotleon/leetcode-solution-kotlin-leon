package com.idiotleon.leetcode.lvl4.lc0139

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/word-break/
 *
 * Time Complexity:     O(L ^ 2) + O(N * L) / O(N) ~ O(L ^ 2)
 * Space Complexity:    O(N)
 */
@Suppress(UNUSED)
class Solution0Bfs {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        // sanity check
        if (s.isEmpty()) {
            return false
        }

        val wordSet = HashSet(wordDict)

        val queue = ArrayDeque<String>().also {
            it.addLast(s)
        }

        val seen = HashSet<String>().also {
            it.add(s)
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()
                val len = cur.length

                for (idx in 1..len) {
                    if (!wordSet.contains(cur.substring(0, idx))) {
                        continue
                    }

                    if (idx == len) {
                        return true
                    }

                    val sub = cur.substring(idx)
                    if (!seen.add(sub)) {
                        continue
                    }
                    queue.addLast(sub)
                }
            }
        }

        return false
    }
}