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
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/discuss/217980/Java-O(N)-with-HashMap-and-prefix-Sum
 */
@Suppress(UNUSED)
class Solution0PrefixSums1 {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        val nNums = nums.size
        val prefixSums = HashMap<Int, Int>(nNums).also {
            it[0] = 1
        }

        var sum = 0
        var count = 0

        for (num in nums) {
            sum += num
            sum %= k

            if (sum < 0) {
                sum += k
            }

            count += prefixSums[sum] ?: 0
            prefixSums[sum] = (prefixSums[sum] ?: 0) + 1
        }

        return count
    }
}