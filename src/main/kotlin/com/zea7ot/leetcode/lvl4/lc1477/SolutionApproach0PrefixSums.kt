/**
 * https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * the approach of prefix sums applies situations where there are negative numbers.
 * the approach below requires only 1 pass of the array.
 *
 * Reference:
 *  https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/discuss/685470/Python-One-pass-prefix-sum-O(n)/578264
 *  https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/discuss/685470/Python-One-pass-prefix-sum-O(n)
 */
package com.zea7ot.leetcode.lvl4.lc1477

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums {
    fun minSumOfLengths(nums: IntArray, target: Int): Int {
        val nNums = nums.size

        val prefixSums = hashMapOf(0 to -1)
        val minLens = IntArray(nNums) { Int.MAX_VALUE }

        var sum = 0
        var ans = Int.MAX_VALUE
        var minLen = Int.MAX_VALUE

        for (idx in nums.indices) {
            sum += nums[idx]

            val key = sum - target

            prefixSums[key]?.let {
                val prevIdx = it
                if (prevIdx > -1 && minLens[prevIdx] != Int.MAX_VALUE) {
                    ans = minOf(ans, idx - prevIdx + minLens[prevIdx])
                }

                minLen = minOf(minLen, idx - prevIdx)
            }

            minLens[idx] = minLen
            prefixSums[sum] = idx
        }

        return if (ans == Int.MAX_VALUE) -1 else ans
    }
}