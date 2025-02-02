package com.idiotleon.leetcode.ood.lvl1.lc0346

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/moving-average-from-data-stream/
 *
 * Time Complexity:     O(`capacity`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0CircularArray(private val capacity: Int) {
    private val nums = MutableList<Int>(capacity) { 0 }
    private var size = 0
    private var sum = 0

    private var head = 0

    fun next(value: Int): Double {
        ++size
        val tail = (head + 1) % capacity

        sum += value
        sum -= nums[tail]

        head = (head + 1) % capacity

        nums[head] = value

        return sum.toDouble() / minOf(size, capacity)
    }
}