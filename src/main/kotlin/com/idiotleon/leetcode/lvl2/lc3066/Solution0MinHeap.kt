package com.idiotleon.leetcode.lvl2.lc3066

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 */
@Suppress(UNUSED)
class Solution0MinHeap {
    fun minOperations(nums: IntArray, k: Int): Int {
        val nNums = nums.size
        val minHeap = PriorityQueue<Long>(nNums).also {
            for (num in nums) {
                it.offer(num.toLong())
            }
        }

        var count = 0
        val k = k.toLong()
        while (minHeap.size >= 2) {
            if (minHeap.peek() >= k) {
                break
            }

            val num1 = minHeap.poll()
            val num2 = minHeap.poll()
            val res = minOf(num1, num2) * 2 + maxOf(num1, num2)
            minHeap.offer(res)
            ++count
        }

        return count
    }
}