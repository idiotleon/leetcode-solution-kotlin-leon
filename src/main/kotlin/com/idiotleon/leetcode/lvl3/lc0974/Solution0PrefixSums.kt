package com.idiotleon.leetcode.lvl3.lc0974

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`k`)
 *
 * If `sum[0, lo] % k == sum[0, hi] % k`,
 * `sum[lo + 1, hi]` is divisible by `k`.
 *
 * So for the current index `hi`,
 * we need to find out how many indices `lo, (lo < hi)` exit,
 * which has the same mod of `k`.
 *
 * Reference:
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/editorial/
 */
@Suppress(UNUSED)
class Solution0PrefixSums {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        val nNums = nums.size
        val modFreq = IntArray(k) { 0 }.also {
            it[0] = 1
        }

        var count = 0
        var sum = 0

        for (num in nums) {
            sum += num
            sum %= k

            if (sum < 0) {
                sum += k
            }

            count += modFreq[sum]
            ++modFreq[sum]
        }

        return count
    }
}