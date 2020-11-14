/**
 * @author: Leon
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Time Complexity:     O(`nNums` * lg(`k`))
 * Space Complexity:    O(`k`)
 */
package com.zea7ot.leetcode.lvl2.lc0215

import java.util.*

class SolutionApproach0MinHeap {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        // not used
        // val nNums = nums.size

        val minHeap = PriorityQueue<Int>()

        for (num in nums) {
            minHeap.offer(num)

            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        return minHeap.poll()
    }
}