package com.idiotleon.leetcode.lvl3.lc2425

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/bitwise-xor-of-all-pairings/
 *
 * Time Complexity:     O(`nNums1` + `nNums2`) ~ O(max(`nNums1`, `nNums2`))
 * Space Complexity:    O(`nNums1` + `nNums2`) ~ O(max(`nNums1`, `nNums2`))
 *
 * Reference:
 * https://leetcode.com/problems/bitwise-xor-of-all-pairings/editorial/
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        val nNums1 = nums1.size
        val nNums2 = nums2.size

        val numToFreq = HashMap<Int, Int>(nNums1 + nNums2).also {
            for (num in nums1) {
                it[num] = nNums2 + (it[num] ?: 0)
            }
            for (num in nums2) {
                it[num] = nNums1 + (it[num] ?: 0)
            }
        }

        var ans = 0
        for ((num, freq) in numToFreq) {
            if (freq % 2 == 1) {
                ans = ans xor num
            }
        }

        return ans
    }
}