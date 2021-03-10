/**
 * @author: Leon
 * https://leetcode.com/problems/create-target-array-in-the-given-order/
 *
 * Time Complexity:     O(`nNums` ^ 2)
 * Space Complexity:    O(`nNums`) / O(1)
 */
package com.an7one.leetcode.lvl3.lc1389

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach2LinkedList {
    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        // not used
        // val nNums = nums.size

        val ans = mutableListOf<Int>()

        for (idx in nums.indices) {
            ans.add(index[idx], nums[idx])
        }

        return ans.toIntArray()
    }
}