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

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun movesToMakeZigzag(nums: IntArray): Int {
        val nNums = nums.size

        // [even, odd]
        val res = IntArray(2) { 0 }
        var lo = 0
        var hi = 0

        for (idx in nums.indices) {
            lo = if (idx - 1 < 0) Int.MAX_VALUE else nums[idx - 1]
            hi = if (idx + 1 >= nNums) Int.MAX_VALUE else nums[idx + 1]

            res[idx % 2] += maxOf(0, nums[idx] - minOf(lo, hi) + 1)
        }

        val (even, odd) = res
        return minOf(even, odd)
    }
}