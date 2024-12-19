package com.idiotleon.leetcode.lvl3.lc3043

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/
 *
 * Time Complexity:     O(`nNums1` + `nNums2`) ~ O(max(`nNums1`, `nNums2`))
 * Space Complexity:    O(`nNums1`)
 *
 * Reference:
 * https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/solutions/4744619/java-solution-easy-to-understand/comments/2263478
 */
@Suppress(UNUSED)
class Solution0HashSet {
    fun longestCommonPrefix(nums1: IntArray, nums2: IntArray): Int {
        val nNums1 = nums1.size
        val prefixes = HashSet<Int>(nNums1).also {
            for (num in nums1) {
                var num1 = num
                while (num1 > 0) {
                    it.add(num1)
                    num1 /= 10
                }
            }
        }

        var longest = 0
        for (num in nums2) {
            var num2 = num
            while (num2 > 0) {
                if (prefixes.contains(num2)) {
                    longest = maxOf(longest, countDigits(num2))
                    break // to prune to optimize
                }
                num2 /= 10
            }
        }

        return longest
    }

    private fun countDigits(num: Int): Int {
        var digits = num
        var count = 0
        while (digits > 0) {
            ++count
            digits /= 10
        }
        return count
    }
}