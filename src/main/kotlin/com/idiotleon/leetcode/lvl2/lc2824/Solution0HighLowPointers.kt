package com.idiotleon.leetcode.lvl2.lc2824

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(1) / O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 */
@Suppress(UNUSED)
class Solution0HighLowPointers {
    fun countPairs(nums: List<Int>, target: Int): Int {
        val nNums = nums.size

        val sorted = nums.sorted()

        var lo = 0
        var hi = nNums - 1
        var count = 0

        while (lo < hi) {
            if (sorted[lo] + sorted[hi] < target) {
                count += hi - lo
                ++lo
            } else {
                --hi
            }
        }

        return count
    }
}