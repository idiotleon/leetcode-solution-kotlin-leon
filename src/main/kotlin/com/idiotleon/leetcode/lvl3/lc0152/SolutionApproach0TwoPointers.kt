package com.idiotleon.leetcode.lvl3.lc0152

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Time Complexity:     O(`nNums`)
 *  nNums, the total amount of elements in the given array
 *
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/maximum-product-subarray/discuss/183483/In-Python-it-can-be-more-concise-PythonC%2B%2BJava
 */
@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun maxProduct(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val nNums = nums.size

        var maxProduct = Int.MIN_VALUE
        var lo = 0
        var hi = 0

        for (idx in nums.indices) {
            lo = (if (lo == 0) 1 else lo) * nums[idx]
            hi = (if (hi == 0) 1 else hi) * nums[nNums - 1 - idx]

            maxProduct = maxOf(maxProduct, lo, hi);
        }

        return maxProduct
    }
}