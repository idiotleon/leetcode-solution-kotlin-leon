/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Time Complexity:     O(size)
 *  size, the amount of elements in the given array
 *
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/maximum-product-subarray/discuss/183483/In-Python-it-can-be-more-concise-PythonC%2B%2BJava
 */
package com.zea7ot.leetcode.lvl3.lc0152

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun maxProduct(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val size = nums.size

        var maxProduct = nums[0]
        var lo = 0
        var hi = 0

        for (i in 0 until size) {
            lo = (if (lo == 0) 1 else lo) * nums[i]
            hi = (if (hi == 0) 1 else hi) * nums[size - 1 - i]

            maxProduct = maxOf(maxProduct, lo, hi);
        }

        return maxProduct
    }
}