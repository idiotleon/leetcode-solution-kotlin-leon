/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl1.lc1464

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun maxProduct(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        var largest = Int.MIN_VALUE
        var secLargest = Int.MIN_VALUE

        for (num in nums) {
            if (num >= largest) {
                secLargest = largest
                largest = num
            } else if (num > secLargest) {
                secLargest = num
            }
        }

        return (largest - 1) * (secLargest - 1)
    }
}