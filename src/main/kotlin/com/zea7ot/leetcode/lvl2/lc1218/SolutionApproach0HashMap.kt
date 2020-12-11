/**
 * https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/discuss/398196/C++-O(n)-DP-using-Hashmap/620510
 */
package com.zea7ot.leetcode.lvl2.lc1218

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun longestSubsequence(nums: IntArray, difference: Int): Int {
        // not used
        // val totalNums = nums.size

        val freqs = HashMap<Int, Int>()
        var longest = 1
        for (num in nums) {
            freqs[num] = 1 + (freqs[num - difference] ?: 0)
            longest = maxOf(longest, freqs[num] ?: 0)
        }

        return longest
    }
}