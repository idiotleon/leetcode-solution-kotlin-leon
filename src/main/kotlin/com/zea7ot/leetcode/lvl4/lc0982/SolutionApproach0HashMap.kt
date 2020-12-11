/**
 * https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/
 *
 * Time Complexity:     O(`nNums` ^ 2)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/discuss/226721/Java-DP-O(3-*-216-*-n)-time-O(216)-space/228036
 */
package com.zea7ot.leetcode.lvl4.lc0982

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun countTriplets(nums: IntArray): Int {
        var count = 0

        val freqs = HashMap<Int, Int>()
        for (idx1 in nums.indices) {
            for (idx2 in nums.indices) {
                val num = nums[idx1] and nums[idx2]
                freqs[num] = 1 + (freqs[num] ?: 0)
            }
        }

        for (idx in nums.indices) {
            for ((num, freq) in freqs) {
                if (nums[idx] and num == 0) {
                    count += freq
                }
            }
        }

        return count
    }
}