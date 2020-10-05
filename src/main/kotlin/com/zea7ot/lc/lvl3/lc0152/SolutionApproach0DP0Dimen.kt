/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Time Complexity:     O(size)
 *  size, the amount of elements in the given array
 *
 * Space Complexity:    O(1)
 *
 * Because that there are possibly negative numbers and 0(s),
 * the maximum product must come from either the previous minimum product(containing odd number of negative numbers) or the maximum product times the current value.
 * And then to compare the current value to get the current minimum or maximum product.
 * Please note that do NOT involve any divide operation, because there might be a zero in the array, which costs extra code.
 */
package com.zea7ot.lc.lvl3.lc0152

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun maxProduct(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        var prevMin = 1
        var prevMax = 1

        var maxProduct = Integer.MIN_VALUE

        for (num in nums) {
            val curMin = minOf(num, prevMax * num, prevMin * num)
            val curMax = maxOf(num, prevMax * num, prevMin * num)

            maxProduct = maxOf(maxProduct, curMax)

            prevMin = curMin
            prevMax = curMax
        }

        return maxProduct
    }
}