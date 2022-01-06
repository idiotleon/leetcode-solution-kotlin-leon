/**
 * https://leetcode.com/problems/set-mismatch/

 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/set-mismatch/discuss/105507/Java-O(n)-Time-O(1)-Space
 */
package com.an7one.leetcode.lvl1.lc0645

import com.an7one.leetcode.util.Constant
import kotlin.math.abs

@Suppress(Constant.Annotation.UNUSED)
class SolutionApproach0LinearScan {
    fun findErrorNums(nums: IntArray): IntArray {
        // not used
        // val nNums = nums.size
        val ans = intArrayOf(0, 0)
        for (num in nums) {
            if (nums[abs(num) - 1] < 0) {
                ans[0] = abs(num)
            } else {
                nums[abs(num) - 1] *= -1
            }
        }
        for ((idx, num) in nums.withIndex()) {
            if (num > 0)
                ans[1] = idx + 1
        }
        return ans
    }
}