package com.idiotleon.leetcode.lvl2.lc0215

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Time Complexity:     O(`nNums` * lg(`k`))
 * Space Complexity:    O(`k`)
 */
@Suppress(UNUSED)
class Solution0MinHeap {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val nNums = nums.size
        val minHeap = PriorityQueue<Int>(nNums)

        for (num in nums) {
            minHeap.offer(num)

            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        return minHeap.poll()
    }
}