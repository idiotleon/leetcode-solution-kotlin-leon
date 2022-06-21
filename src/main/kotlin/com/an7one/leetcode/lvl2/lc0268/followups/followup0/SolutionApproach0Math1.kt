package com.an7one.leetcode.lvl2.lc0268.followups.followup0

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/missing-number/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination/71891
 */
@Suppress(UNUSED)
class SolutionApproach0Math1 {
    fun missingNumber(nums: IntArray): Int {
        val nNums = nums.size

        // this assumes that the product and sum do not cause integer overflow
        return nNums * (nNums + 1) / 2 - nums.sum()
    }
}