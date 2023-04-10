package com.idiotleon.leetcode.lvl3.lc0238

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Time Complexity:     O(2 * `nNums`) ~ O(`nNums`)
 * Space Complexity:    O(`nNums`) / O(1)
 *
 * Reference:
 * https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val nNums = nums.size
        val ans = IntArray(nNums) { 0 }
        // sanity check
        if (nums.isEmpty()) return ans

        ans[0] = 1
        for (i in 1 until nNums) {
            ans[i] = nums[i - 1] * ans[i - 1]
        }

        var prevProduct = 1
        for (idx in nNums - 1 downTo 0) {
            ans[idx] *= prevProduct
            prevProduct *= nums[idx]
        }

        return ans
    }
}