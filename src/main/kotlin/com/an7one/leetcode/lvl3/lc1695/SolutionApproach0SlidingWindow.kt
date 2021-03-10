/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-erasure-value/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 */
package com.an7one.leetcode.lvl3.lc1695

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        val nNums = nums.size

        var lo = 0
        var hi = 0
        var largest = 0
        var sum = 0

        val seen = HashSet<Int>()

        while (hi < nNums) {
            // to accumulate the running sum
            sum += nums[hi]

            // to narrow the sliding window,
            // once any previously visited element has been found,
            // till it has been removed in the current (sliding) window.
            while (seen.contains(nums[hi])) {
                sum -= nums[lo]
                seen.remove(nums[lo])
                ++lo
            }

            // to mark the element as visited
            seen.add(nums[hi])

            // to keep track of the largest sum ever exists
            largest = maxOf(largest, sum)

            // to enlarge the window
            ++hi
        }

        return largest
    }
}