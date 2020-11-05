/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 *
 * Time Complexity:     O(`nNUms` * lg(`nNums`)) + O(2 * `nNums`) ~ O(`nNUms` * lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/103070/Java-Solution-Sort./106342
 *  https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/103070/Java-Solution-Sort.
 */
package com.zea7ot.leetcode.lvl2.lc0581

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy2 {
    fun findUnsortedSubarray(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        val sorted = nums.sorted()

        var start = -1
        var end = -1

        for (idx in nums.indices) {
            if (nums[idx] != sorted[idx]) {
                if (start == -1) {
                    start = idx
                }

                end = idx
            }
        }

        return if (start == -1) 0 else end - start + 1
    }
}