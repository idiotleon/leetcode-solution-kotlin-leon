/**
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(N) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space
 */
package com.an7one.leetcode.lvl3.lc0238

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun productExceptSelf(nums: IntArray): IntArray {
        val size = nums.size
        val ans = IntArray(size)
        // sanity check
        if (nums.isEmpty()) return ans

        ans[0] = 1
        for (i in 1 until size) {
            ans[i] = nums[i - 1] * ans[i - 1]
        }

        var res = 1
        for (i in size - 1 downTo 0) {
            ans[i] *= res
            res *= nums[i]
        }

        return ans
    }
}