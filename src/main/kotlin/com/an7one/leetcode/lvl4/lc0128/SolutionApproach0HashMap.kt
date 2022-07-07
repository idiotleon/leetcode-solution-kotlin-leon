package com.an7one.leetcode.lvl4.lc0128

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted/39096
 * https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
 */
@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun longestConsecutive(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        val numToSeqLen = HashMap<Int, Int>()

        var longest = 0

        loop@ for (num in nums) {
            if (numToSeqLen.containsKey(num)) continue@loop

            val lo = numToSeqLen[num - 1] ?: 0
            val hi = numToSeqLen[num + 1] ?: 0
            val curLen = lo + hi + 1

            numToSeqLen[num] = curLen
            longest = maxOf(longest, curLen)

            if (lo > 0) numToSeqLen[num - lo] = curLen

            if (hi > 0) numToSeqLen[num + hi] = curLen
        }

        return longest
    }
}