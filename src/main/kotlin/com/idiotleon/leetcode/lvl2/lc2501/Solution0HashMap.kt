package com.idiotleon.leetcode.lvl2.lc2501

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.sqrt

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-square-streak-in-an-array/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/longest-square-streak-in-an-array/solutions/2899678/short-dp-cjava-lis-type-by-xxvvpp-8ipo/
 */
@Suppress(UNUSED)
class Solution0HashMap {
    fun longestSquareStreak(nums: IntArray): Int {
        val nNums = nums.size
        nums.sort()
        val numToFreq = HashMap<Int, Int>(nNums)
        var longest = 0
        for (num in nums) {
            val root = sqrt(num.toDouble()).toInt()
            if (root * root == num) {
                numToFreq[num] = 1 + (numToFreq[root] ?: 0)
            } else {
                numToFreq[num] = 1
            }
            longest = maxOf(longest, numToFreq[num] ?: 0)
        }
        return if (longest < 2) {
            -1
        } else {
            longest
        }
    }
}