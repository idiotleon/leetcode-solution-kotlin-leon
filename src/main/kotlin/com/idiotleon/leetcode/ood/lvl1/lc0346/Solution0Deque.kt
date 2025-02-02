package com.idiotleon.leetcode.ood.lvl1.lc0346

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/moving-average-from-data-stream/
 *
 * Time Complexity:
 *  `next`:             O(1)
 * Space Complexity:    O(`capacity`)
 */
@Suppress(UNUSED)
class Solution0Deque(private val capacity: Int) {
    private val deque = ArrayDeque<Int>()
    private var size = 0
    private var sum = 0

    fun next(value: Int): Double {
        sum += value
        deque.addLast(value)

        if (size == capacity) {
            sum -= deque.removeFirst()
        } else {
            ++size
        }

        return sum.toDouble() / size
    }
}