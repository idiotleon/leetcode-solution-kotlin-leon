/**
 * @author: Leon
 * https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 *
 * Time Complexity:     O(lg(`target`))
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl3.lc0702

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    private companion object {
        private const val RANGE = 2147483647
    }

    fun search(reader: FakeArrayReader, target: Int): Int {
        var steps = 1

        var lo = 0
        var hi = 0

        while (hi < RANGE) {
            lo = hi
            steps *= 2
            hi += steps
            if (reader.get(hi) >= target) {
                break
            }
        }

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (reader.get(mid) < target) {
                lo = mid + 1
            } else hi = mid
        }

        return if (reader.get(lo) == target) lo else -1
    }
}