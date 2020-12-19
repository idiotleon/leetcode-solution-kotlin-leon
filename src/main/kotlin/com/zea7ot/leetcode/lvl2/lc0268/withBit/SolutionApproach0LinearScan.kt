/**
 * https://leetcode.com/problems/missing-number/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination/119313
 *  https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination
 */
package com.zea7ot.leetcode.lvl2.lc0268.withBit

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

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