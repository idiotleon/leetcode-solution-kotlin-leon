package com.idiotleon.leetcode.lvl3.lc0152

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Time Complexity:     O(`nNums`)
 *  size, the amount of elements in the given array
 *
 * Space Complexity:    O(1)
 *
 * Because that there are possibly negative numbers and 0(s),
 * the maximum product must come from either the previous minimum product(containing odd number of negative numbers) or the maximum product times the current value.
 * And then to compare the current value to get the current minimum or maximum product.
 * Please note that do NOT involve any divide operation, because there might be a zero in the array, which costs extra code.
 *
 * Reference:
 * https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity
 */
@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun maxProduct(nums: IntArray): Int {
        // not used
        // val nNums = nums.size
        // sanity check
        if (nums.isEmpty()) return 0

        var prevMin = 1
        var prevMax = 1

        var maxProduct = Integer.MIN_VALUE

        for (num in nums) {
            val curMin = minOf(num, prevMin * num, prevMax * num)
            val curMax = maxOf(num, prevMin * num, prevMax * num)

            maxProduct = maxOf(maxProduct, curMax)

            prevMin = curMin
            prevMax = curMax
        }

        return maxProduct
    }
}