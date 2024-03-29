package com.idiotleon.leetcode.lvl2.lc0414

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

/**
 * @author: Leon
 * https://leetcode.com/problems/third-maximum-number/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@Suppress(UNUSED)
class SolutionApproach1MinHeap {
    fun thirdMax(nums: IntArray): Int {
        val minHeap = PriorityQueue<Int>()
        val seen = HashSet<Int>()
        for (num in nums) {
            if (seen.add(num)) {
                minHeap.offer(num)
                if (minHeap.size > 3)
                    seen.remove(minHeap.poll())
            }
        }

        if (minHeap.size < 3) {
            while (minHeap.size > 1) {
                minHeap.poll()
            }
        }

        return minHeap.peek()
    }
}