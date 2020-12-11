/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation/162249
 *  https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation
 */
package com.zea7ot.leetcode.lvl4.lc0769

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun maxChunksToSorted(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        // not used
        // val totalNums = nums.size

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