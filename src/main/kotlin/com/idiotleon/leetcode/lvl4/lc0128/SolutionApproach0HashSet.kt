package com.idiotleon.leetcode.lvl4.lc0128

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted/191109
 */
@Suppress(UNUSED)
class SolutionApproach0HashSet {
    fun longestConsecutive(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        val set = nums.toHashSet()

        var longest = 0

        loop@ for (num in nums) {
            var lo = num - 1
            var hi = num + 1

            while (set.remove(lo)) --lo
            while (set.remove(hi)) ++hi

            val curLen = hi - lo - 1

            longest = maxOf(longest, curLen)

            if (set.isEmpty()) break@loop
        }

        return longest
    }
}