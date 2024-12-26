package com.idiotleon.leetcode.lvl4.lc2009

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/solutions/1470853/python-binary-search-clean-concise-by-hi-9rcn/comments/1300001
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/solutions/1470853/python-binary-search-clean-concise-by-hi-9rcn/
 */
@Suppress(UNUSED)
class Solution0SlidingWindow {
    fun minOperations(nums: IntArray): Int {
        val nNums = nums.size
        val sorted = nums.distinct().sorted()
        val nSorted = sorted.size

        var ans = nNums
        var idx = 0
        for ((idxStart, numStart) in sorted.withIndex()) {
            val numEnd = numStart + nNums - 1
            while (idx + 1 < nSorted && sorted[idx + 1] <= numEnd) {
                ++idx
            }
            val len = idx - idxStart + 1
            ans = minOf(ans, nNums - len)
        }

        return ans
    }
}