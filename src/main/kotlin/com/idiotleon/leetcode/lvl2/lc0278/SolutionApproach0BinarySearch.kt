package com.idiotleon.leetcode.lvl2.lc0278

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/first-bad-version/
 *
 * Time Complexity:     O(lg(`n`))
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0BinarySearch : FakeVersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var lo = 1
        var hi = n

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2

            if (!isBadVersion(mid) && isBadVersion(mid + 1))
                return 1 + mid

            if (!isBadVersion(mid))
                lo = mid + 1
            else
                hi = mid - 1
        }

        return 1
    }
}