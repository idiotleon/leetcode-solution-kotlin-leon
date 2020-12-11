/**
 * https://leetcode.com/problems/brace-expansion/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/brace-expansion/discuss/571761/Simple-BFS-Solution-(Like-Word-Ladder)
 */
package com.zea7ot.leetcode.lvl3.lc1087

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    private companion object {
        private val REGEX = "[{}]".toRegex()
    }

    fun expand(str: String): Array<String> {
        val strs = str.split(REGEX)
        val nStrs = strs.size

        val queue = LinkedList<String>().also {
            it.offer("")
        }

        var idx = 0
        while (queue.isNotEmpty() && idx < nStrs) {
            val size = queue.size
            val curStr = strs[idx]
            val chStrs = curStr.split(",").toTypedArray().also { it.sort() }

            for (sz in 0 until size) {
                val cur = queue.poll()

                for (ch in chStrs) {
                    queue.offer(cur + ch)
                }
            }

            ++idx
        }

        return queue.toTypedArray()
    }
}