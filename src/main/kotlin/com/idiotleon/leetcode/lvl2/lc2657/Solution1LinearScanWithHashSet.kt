package com.idiotleon.leetcode.lvl2.lc2657

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
 *
 * Time Complexity:     O(`nNums` ^ 2)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/editorial/
 */
@Suppress(UNUSED)
class Solution1LinearScanWithHashSet {
    fun findThePrefixCommonArray(nums1: IntArray, nums2: IntArray): IntArray {
        val nNums = nums1.size
        val ans = IntArray(nNums) { 0 }
        val seen = HashSet<Int>(nNums)

        for ((idx1, num1) in nums1.withIndex()) {
            seen.add(num1)

            var count = 0
            for (idx2 in 0..idx1) {
                if (seen.contains(nums2[idx2])) {
                    ++count
                }
            }

            ans[idx1] = count
        }

        return ans
    }
}