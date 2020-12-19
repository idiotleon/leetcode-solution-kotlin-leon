/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl1.lc1464

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun maxProduct(nums: IntArray): Int {
        // not used
        // val totalNums = nums.size

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