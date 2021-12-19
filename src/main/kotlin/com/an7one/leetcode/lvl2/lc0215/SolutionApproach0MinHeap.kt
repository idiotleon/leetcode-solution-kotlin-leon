/**
 * @author: Leon
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Time Complexity:     O(`nNums` * lg(`k`))
 * Space Complexity:    O(`k`)
 */
package com.an7one.leetcode.lvl2.lc0215

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MinHeap {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        // not used
        // val nNums = nums.size

        val minHeap = PriorityQueue<Int>()

        for (num in nums) {
            minHeap.offer(num)

            if (minHeap.size > k)
                minHeap.poll()
        }

        return minHeap.poll()
    }
}