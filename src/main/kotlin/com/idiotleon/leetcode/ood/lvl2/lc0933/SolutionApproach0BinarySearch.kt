/**
 * https://leetcode.com/problems/number-of-recent-calls/
 *
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(N)
 *
 * References:
 *  https://leetcode.com/problems/number-of-recent-calls/discuss/189239/JavaPython-3-Five-solutions%3A-TreeMap-TreeSet-ArrayList-Queue-Circular-List.
 */
package com.idiotleon.leetcode.ood.lvl2.lc0933

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    private companion object {
        private const val DURATION = 3000
    }

    private val list = mutableListOf<Int>()

    fun ping(t: Int): Int {
        list.add(t)
        var idx = list.binarySearch(t - DURATION)
        if (idx < 0) idx = idx.inv()
        return list.size - idx
    }
}