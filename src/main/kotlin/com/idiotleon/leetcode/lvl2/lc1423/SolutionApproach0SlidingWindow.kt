/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 *
 * Time Complexity:     O(`nCards`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/discuss/597763/Python3-Easy-Sliding-Window-O(n):-Find-minimum-subarray/517069
 */
package com.idiotleon.leetcode.lvl2.lc1423

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        val nCards = cardPoints.size

        val windowSize = nCards - k

        var totalPoints = 0
        var min = Int.MAX_VALUE

        var curPoints = 0
        var lo = 0
        var hi = 0

        while (hi < nCards) {
            totalPoints += cardPoints[hi]
            curPoints += cardPoints[hi]

            val len = hi - lo + 1
            if (len == windowSize) {
                min = minOf(min, curPoints)
                curPoints -= cardPoints[lo]
                ++lo
            }

            ++hi
        }

        return totalPoints - if (min == Int.MAX_VALUE) 0 else min
    }
}