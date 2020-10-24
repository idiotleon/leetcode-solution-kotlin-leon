/**
 * @author: Leon
 * https://leetcode.com/problems/create-target-array-in-the-given-order/
 *
 * Time Complexity:     O(`totalNums` ^ 2)
 * Space Complexity:    O(`totalNums`) / O(1)
 */
package com.zea7ot.leetcode.lvl3.lc1389

import java.util.*

class SolutionApproach2LinkedList {
    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        // not used
        // val totalNums = nums.size

        val ans = LinkedList<Int>()

        for (idx in nums.indices) {
            ans.add(index[idx], nums[idx])
        }

        return ans.toIntArray()
    }
}