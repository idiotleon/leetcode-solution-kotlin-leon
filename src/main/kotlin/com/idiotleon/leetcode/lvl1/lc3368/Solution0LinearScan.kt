package com.idiotleon.leetcode.lvl1.lc3368

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/button-with-longest-push-time/
 *
 * Time Complexity:     O(`nEvents`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/button-with-longest-push-time/solutions/6147732/easy-5-lines-code-100-beats/
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun buttonWithLongestTime(events: Array<IntArray>): Int {
        val nEvents = events.size
        var longest = events[0][1]
        var ans = events[0][0]

        for (idx in 1 until nEvents) {
            val duration = events[idx][1] - events[idx - 1][1]
            if (duration > longest || (duration == longest && events[idx][0] < ans)) {
                longest = duration
                ans = events[idx][0]
            }
        }

        return ans
    }
}