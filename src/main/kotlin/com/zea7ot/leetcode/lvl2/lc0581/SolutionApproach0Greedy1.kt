/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 *
 * Time Complexity:     O(`nNUms` * lg(`nNums`)) + O(2 * `nNums`) ~ O(`nNUms` * lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/103070/Java-Solution-Sort.
 */
package com.zea7ot.leetcode.lvl2.lc0581

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy1 {
    fun findUnsortedSubarray(nums: IntArray): Int {
        val nNums = nums.size
        val sorted = nums.sorted()

        var start = 0
        while (start < nNums && nums[start] == sorted[start]) ++start

        var end = nNums - 1
        while (end > start && nums[end] == sorted[end]) --end

        return end - start + 1
    }
}