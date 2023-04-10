package com.idiotleon.leetcode.lvl2.lc0136.withBit

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/single-number/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/single-number/discuss/42997/My-O(n)-solution-using-XOR
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun singleNumber(nums: IntArray): Int {
        var single = 0
        for (num in nums) {
            single = single xor num
        }

        return single
    }
}