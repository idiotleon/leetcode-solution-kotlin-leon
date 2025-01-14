package com.idiotleon.leetcode.lvl2.lc2657

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/editorial/
 */
@Suppress(UNUSED)
class Solution0LinearScanWithFreqArray {
    fun findThePrefixCommonArray(nums1: IntArray, nums2: IntArray): IntArray {
        val nNums = nums1.size
        val ans = IntArray(nNums) { 0 }
        val freqs = IntArray(nNums + 1) { 0 }

        var count = 0
        for (idx in 0 until nNums) {
            if (++freqs[nums1[idx]] == 2) {
                ++count
            }
            if (++freqs[nums2[idx]] == 2) {
                ++count
            }
            ans[idx] = count
        }

        return ans
    }
}