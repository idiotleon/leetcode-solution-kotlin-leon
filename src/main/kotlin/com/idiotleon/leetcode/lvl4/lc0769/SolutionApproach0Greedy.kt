package com.idiotleon.leetcode.lvl4.lc0769

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation/162249
 * https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation
 */
@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun maxChunksToSorted(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        // not used
        // val nNums = nums.size

        var count = 0
        var max = 0

        for (idx in nums.indices) {
            max = maxOf(max, nums[idx])

            if (max == idx) {
                ++count
            }
        }

        return count
    }
}