/**
 * https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/discuss/350576/JavaC++Python-Easy-and-concise/318347
 *  https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/discuss/350713/Read-my-short-proof-if-you-feel-confused.
 */
package com.zea7ot.leetcode.lvl3.lc1144

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun movesToMakeZigzag(nums: IntArray): Int {
        val nNums = nums.size

        var odd = 0
        var even = 0
        var lo: Int
        var hi: Int

        for (idx in nums.indices) {
            lo = if (idx - 1 < 0) Int.MAX_VALUE else nums[idx - 1]
            hi = if (idx + 1 >= nNums) Int.MAX_VALUE else nums[idx + 1]

            val min = minOf(lo, hi)

            if (idx % 2 == 0) {
                if (nums[idx] >= min) {
                    even += nums[idx] - min + 1
                }
            } else {
                if (nums[idx] >= min) {
                    odd += nums[idx] - min + 1
                }
            }
        }

        return minOf(odd, even)
    }
}