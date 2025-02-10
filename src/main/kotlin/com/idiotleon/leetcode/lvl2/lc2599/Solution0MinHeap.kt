package com.idiotleon.leetcode.lvl2.lc2599

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/make-the-prefix-sum-non-negative/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/make-the-prefix-sum-non-negative/editorial
 */
@Suppress(UNUSED)
class Solution0MinHeap {
    fun makePrefSumNonNegative(nums: IntArray): Int {
        val nNums = nums.size

        var sum: Long = 0L
        var count = 0
        val minHeap = PriorityQueue<Int>(nNums)
        for (num in nums) {
            if (num < 0) {
                minHeap.offer(num)
            }

            sum += num
            if (sum < 0) {
                sum -= minHeap.poll()
                ++count
            }
        }

        return count
    }
}