/**
 * https://leetcode.com/problems/max-dot-product-of-two-subsequences/
 *
 * Time Complexity:     O(`nNums1` * `nNums2`)
 * Space Complexity:    O(`nNums1` * `nNums2`)
 *
 * References:
 *  https://leetcode.com/problems/max-dot-product-of-two-subsequences/discuss/649858/JavaPython-3-2-Clean-DP-codes-of-O(mn)-and-O(min(m-n))-space-w-breif-explanation-and-analysis.
 */
package com.zea7ot.leetcode.lvl4.lc1458

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
        val nNums1 = nums1.size
        val nNums2 = nums2.size

        val dp = Array(nNums1 + 1) { IntArray(nNums2 + 1) { 0 } }

        var largest = Int.MIN_VALUE

        for (idx1 in nums1.indices) {
            for (idx2 in nums2.indices) {
                var product = nums1[idx1] * nums2[idx2]
                largest = maxOf(largest, product)
                product = maxOf(0, product)

                dp[idx1 + 1][idx2 + 1] = maxOf(
                    dp[idx1][idx2] + product,
                    dp[idx1 + 1][idx2],
                    dp[idx1][idx2 + 1]
                )
            }
        }

        return if (largest <= 0) largest else dp[nNums1][nNums2]
    }
}