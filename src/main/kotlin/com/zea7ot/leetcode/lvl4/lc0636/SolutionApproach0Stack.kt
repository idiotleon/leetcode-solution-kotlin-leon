/**
 * https://leetcode.com/problems/exclusive-time-of-functions/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * `stack` is used to save the IDs, which should be pused in if it is a start, of functions
 *
 * References:
 *  https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space
 *  https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space/107796
 */
package com.zea7ot.leetcode.lvl4.lc0636

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val STATE_START = "start"
        private const val SPLITTER = ":"
    }

    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val ans = IntArray(n)
        // sanity check
        if (n == 0 && logs.isEmpty()) return ans

        val stack: Deque<Int> = LinkedList<Int>()
        var prevTimestamp = 0

        for (log in logs) {
            val res: List<String> = log.split(SPLITTER)
            val id: Int = res[0].toInt()
            val state: String = res[1]
            val curTimestamp: Int = res[2].toInt()

            if (!stack.isEmpty())
                ans[stack.peek()] += (curTimestamp - prevTimestamp)

            prevTimestamp = curTimestamp

            if (state == STATE_START) {
                stack.push(id)
            } else {
                ++ans[stack.pop()]
                ++prevTimestamp
            }
        }

        return ans
    }
}