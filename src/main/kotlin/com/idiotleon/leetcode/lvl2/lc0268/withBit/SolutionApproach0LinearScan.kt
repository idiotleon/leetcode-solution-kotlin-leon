package com.idiotleon.leetcode.lvl2.lc0268.withBit

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/missing-number/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination/119313
 *  https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun missingNumber(nums: IntArray): Int {
        val nNums = nums.size
        var ans = nNums
        for (idx in nums.indices) {
            ans = ans xor idx xor nums[idx]
        }

        return ans
    }
}