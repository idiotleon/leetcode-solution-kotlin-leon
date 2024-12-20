package com.idiotleon.leetcode.lvl2.lc2501

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.sqrt

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-square-streak-in-an-array/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/longest-square-streak-in-an-array/solutions/2899909/set-with-optimizations-by-votrubac-llh8/comments/1923106
 */
@Suppress(UNUSED)
class Solution0HashSet {
    fun longestSquareStreak(nums: IntArray): Int {
        val nNums = nums.size
        val set = nums.toHashSet()
        var longest = 0
        for (num in nums) {
            var count = 0
            var lo = num
            while (set.contains(lo)) {
                set.remove(lo)
                val root = sqrt(lo.toDouble()).toInt()
                lo = if (root * root == lo) {
                    root
                } else {
                    -1
                }
                ++count
                longest = maxOf(longest, count)
            }

            var hi = num * num
            while (set.contains(hi)) {
                set.remove(hi)
                hi *= hi
                ++count
                longest = maxOf(longest, count)
            }
        }
        return if (longest < 2) {
            -1
        } else {
            longest
        }
    }
}