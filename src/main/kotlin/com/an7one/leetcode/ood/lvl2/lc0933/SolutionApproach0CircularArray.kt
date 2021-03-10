/**
 * https://leetcode.com/problems/number-of-recent-calls/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(`DURATION`)
 *
 * References:
 *  https://leetcode.com/problems/number-of-recent-calls/discuss/189239/JavaPython-3-Five-solutions%3A-TreeMap-TreeSet-ArrayList-Queue-Circular-List.
 */
package com.an7one.leetcode.ood.lvl2.lc0933

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0CircularArray {
    private companion object {
        private const val DURATION = 3000 + 1
    }

    private val time = IntArray(DURATION) { 0 }

    fun ping(t: Int): Int {
        var res = 0
        time[t % DURATION] = t
        for (idx in 0 until DURATION) {
            if (time[idx] != 0 && time[idx] >= t - DURATION) ++res
        }

        return res
    }
}