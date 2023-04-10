package com.idiotleon.leetcode.lvl4.lc0752

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

/**
 * @author: Leon
 * https://leetcode.com/problems/open-the-lock/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/open-the-lock/discuss/110237/Regular-java-BFS-solution-and-2-end-BFS-solution-with-improvement/303702
 * https://leetcode.com/problems/open-the-lock/discuss/110237/Regular-java-BFS-solution-and-2-end-BFS-solution-with-improvement
 */
@SuppressWarnings(UNUSED)
class SolutionApproach0BFS {
    fun openLock(deadends: Array<String>, target: String): Int {
        val queue = ArrayDeque<String>().also {
            it.addLast("0000")
        }
        val locked = deadends.toHashSet()
        val seen = HashSet<String>().also {
            it.add("0000")
        }

        var level = 0

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()
                if (locked.contains(cur)) continue

                if (cur == target) return level

                val nextStrs = getNextStrs(cur)
                for (next in nextStrs) {
                    if (seen.add(next) && !locked.contains(next)) queue.addLast(next)
                }
            }

            ++level
        }

        return -1
    }

    private fun getNextStrs(prev: String): List<String> {
        val nextStrs = mutableListOf<String>()
        for (idx in prev.indices) {
            val wheel = prev[idx] - '0'
            val str1 = prev.substring(0, idx) + ((10 + wheel + 1) % 10).toString() + prev.substring(idx + 1)
            nextStrs.add(str1)
            val str2 = prev.substring(0, idx) + ((10 + wheel - 1) % 10).toString() + prev.substring(idx + 1)
            nextStrs.add(str2)
        }
        return nextStrs
    }
}