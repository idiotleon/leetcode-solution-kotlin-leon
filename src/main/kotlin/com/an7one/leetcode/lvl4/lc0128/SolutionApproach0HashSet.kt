/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted/191109
 */
package com.an7one.leetcode.lvl4.lc0128

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashSet {
    fun longestConsecutive(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        var longest = 0

        val set = HashSet<Int>().also {
            for (num in nums) it.add(num)
        }

        for (num in nums) {
            var lo = num - 1
            var hi = num + 1

            while (set.remove(lo)) --lo
            while (set.remove(hi)) ++hi

            longest = maxOf(longest, hi - lo - 1)

            if (set.isEmpty()) return longest
        }

        return longest
    }
}