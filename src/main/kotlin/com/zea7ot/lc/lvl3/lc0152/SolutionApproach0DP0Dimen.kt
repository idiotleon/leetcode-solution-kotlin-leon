/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * Because that there are possibly negative numbers and 0(s),
 * the maximum product must come from either the previous minimum product(containing odd number of negative numbers) or the maximum product times the current value.
 * And then to compare the current value to get the current minimum or maximum product.
 * Please note that do NOT involve any divide operation, because there might be a zero in the array, which costs extra code.
 */
package com.zea7ot.lc.lvl3.lc0152

class SolutionApproach0DP0Dimen {
    fun maxProduct(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val size = nums.size

        var minProduct = 1
        var maxProduct = 1
        var ans = nums[0]

        for (num in nums) {
            val curMin = minOf(num, minProduct * num, maxProduct * num)
            val curMax = maxOf(num, minProduct * num, maxProduct * num)

            minProduct = curMin
            maxProduct = curMax

            ans = maxOf(ans, maxProduct)
        }

        return ans
    }
}