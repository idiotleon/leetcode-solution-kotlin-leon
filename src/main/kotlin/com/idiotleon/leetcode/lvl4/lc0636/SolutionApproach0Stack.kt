package com.idiotleon.leetcode.lvl4.lc0636

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/exclusive-time-of-functions/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * `stack` is used to save the IDs, which should be pushed in if it is the start of functions
 *
 * Reference:
 * https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space
 * https://leetcode.com/problems/exclusive-time-of-functions/discuss/105062/Java-Stack-Solution-O(n)-Time-O(n)-Space/107796
 */
@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val STATE_START = "start"
        private const val SPLITTER = ":"
    }

    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val ans = IntArray(n) { 0 }

        val stack = ArrayDeque<Int>()
        var prevTimestamp = 0

        for (log in logs) {
            val res = log.split(SPLITTER)
            val id = res[0].toInt()
            val state = res[1]
            val curTimestamp = res[2].toInt()

            if (stack.isNotEmpty()) {
                ans[stack.last()] += (curTimestamp - prevTimestamp)
            }

            prevTimestamp = curTimestamp

            if (state == STATE_START) {
                stack.addLast(id)
            } else {
                ++ans[stack.removeLast()]
                ++prevTimestamp
            }
        }

        return ans
    }
}