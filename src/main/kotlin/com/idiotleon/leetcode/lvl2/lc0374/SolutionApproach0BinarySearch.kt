package com.idiotleon.leetcode.lvl2.lc0374

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 *
 * Time Complexity:     O(lg(`n`))
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0BinarySearch : FakeGuessGame() {
    override fun guessNumber(n: Int): Int {
        var lo = 1
        var hi = n

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (guess(mid) == 1) lo = mid + 1
            else hi = mid
        }

        return if (guess(lo) == 0) lo else -1
    }
}