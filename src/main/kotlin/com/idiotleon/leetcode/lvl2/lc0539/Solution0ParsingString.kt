package com.idiotleon.leetcode.lvl2.lc0539

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-time-difference/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 */
@Suppress(UNUSED)
class Solution0ParsingString {
    private companion object {
        const val RANGE = 24 * 60 * 60
        const val SPLITTER = ':'
    }

    fun findMinDifference(nums: List<String>): Int {
        val nNums = nums.size
        val minutes = IntArray(nNums) { 0 }.also {
            for ((idx, num) in nums.withIndex()) {
                val (hourString, minuteString) = num.split(SPLITTER)
                val hour = hourString.toInt()
                val minute = minuteString.toInt()
                it[idx] = hour * 60 + minute
            }
            it.sort()
        }

        var diff = RANGE
        for (idx in 0 until nNums - 1) {
            diff = minOf(diff, minutes[1 + idx] - minutes[idx])
        }

        return minOf(diff, 24 * 60 - minutes.last() + minutes.first())
    }
}