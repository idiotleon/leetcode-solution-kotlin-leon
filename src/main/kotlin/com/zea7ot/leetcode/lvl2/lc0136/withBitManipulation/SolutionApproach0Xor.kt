/**
 * https://leetcode.com/problems/single-number/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/single-number/discuss/42997/My-O(n)-solution-using-XOR
 */
package com.zea7ot.leetcode.lvl2.lc0136.withBitManipulation

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Xor {
    fun singleNumber(nums: IntArray): Int {
        // not used
        // val totalNums = nums.size

        var single = 0

        for (num in nums) {
            single = single xor num
        }

        return single
    }
}