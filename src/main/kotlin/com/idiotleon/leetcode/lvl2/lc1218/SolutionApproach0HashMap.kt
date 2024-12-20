package com.idiotleon.leetcode.lvl2.lc1218

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/discuss/398196/C++-O(n)-DP-using-Hashmap/620510
 */
@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun longestSubsequence(nums: IntArray, difference: Int): Int {
        val nNums = nums.size

        val numToFreq = HashMap<Int, Int>(nNums)
        var longest = 1
        for (num in nums) {
            numToFreq[num] = 1 + (numToFreq[num - difference] ?: 0)
            longest = maxOf(longest, numToFreq[num] ?: 0)
        }

        return longest
    }
}