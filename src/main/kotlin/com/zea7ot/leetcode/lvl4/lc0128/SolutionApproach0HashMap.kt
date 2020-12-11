/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted/39096
 *  https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
 */
package com.zea7ot.leetcode.lvl4.lc0128

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun longestConsecutive(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        var longest = 0

        val rangeMap = HashMap<Int, Int>()
        for (num in nums) {
            if (rangeMap.containsKey(num)) continue

            val lo = rangeMap[num - 1] ?: 0
            val hi = rangeMap[num + 1] ?: 0
            val len = lo + hi + 1

            rangeMap[num] = len
            longest = maxOf(longest, len)

            if (lo > 0) rangeMap[num - lo] = len
            if (hi > 0) rangeMap[num + hi] = len
        }

        return longest
    }
}