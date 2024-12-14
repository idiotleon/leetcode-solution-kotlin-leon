package com.idiotleon.leetcode.lvl3.lc0169

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/majority-element/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * the description of the problem guarantees that there always will be a majority element
 *
 * Reference:
 * https://leetcode.com/problems/majority-element/discuss/51613/O(n)-time-O(1)-space-fastest-solution
 * https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
 */
@Suppress(UNUSED)
class SolutionApproach0MooreVotingAlgorithm1 {
    fun majorityElement(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) {
            return 0
        }

        val nNums = nums.size

        var major = nums[0]
        var count = 1

        for (i in 1 until nNums) {
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