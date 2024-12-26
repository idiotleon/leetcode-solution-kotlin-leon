package com.idiotleon.leetcode.lvl3.lc0713

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/subarray-product-less-than-k/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/subarray-product-less-than-k/solutions/108861/java-c-clean-code-with-explanation/
 */
@Suppress(UNUSED)
class Solution0SlidingWindow {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        val nNums = nums.size

        var count = 0
        var product = 1
        var lo = 0
        var hi = 0

        while (hi < nNums) {
            product *= nums[hi]

            while (lo <= hi && product >= k) {
                product /= nums[lo]
                ++lo
            }

            count += hi - lo + 1
            ++hi
        }

        return count
    }
}