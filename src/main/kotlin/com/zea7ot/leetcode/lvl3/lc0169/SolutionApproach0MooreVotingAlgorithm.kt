/**
 * https://leetcode.com/problems/majority-element/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * the description of the problem guarantees that there always will be a majority element
 *
 * References:
 *  https://leetcode.com/problems/majority-element/discuss/51613/O(n)-time-O(1)-space-fastest-solution
 *  https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
 */
package com.zea7ot.leetcode.lvl3.lc0169

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0MooreVotingAlgorithm {
    fun majorityElement(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0;

        val size = nums.size

        var major = nums[0]
        var count = 1

        for (i in 1 until size) {
            when {
                count == 0 -> {
                    ++count
                    major = nums[i]
                }
                major == nums[i] -> ++count
                else -> --count
            }
        }

        return major
    }
}