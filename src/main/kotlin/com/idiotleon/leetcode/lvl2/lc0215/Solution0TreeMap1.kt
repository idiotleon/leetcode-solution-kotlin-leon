package com.idiotleon.leetcode.lvl2.lc0215

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/***
 * @author: Leon
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 */
@Suppress(UNUSED)
class Solution0TreeMap1 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val nNums = nums.size

        val numToFreq = TreeMap<Int, Int>().also {
            for (num in nums) {
                it[num] = 1 + (it[num] ?: 0)
            }
        }

        var countK = 0
        for ((num, freq) in numToFreq.descendingMap()) {
            countK += freq
            if (countK >= k) {
                return num
            }
        }

        throw UnsupportedOperationException()
    }
}