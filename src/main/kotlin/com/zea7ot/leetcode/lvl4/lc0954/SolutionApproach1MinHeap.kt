/**
 * https://leetcode.com/problems/array-of-doubled-pairs/
 *
 * Time Complexity:     O(`nNums` ^ 2)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/array-of-doubled-pairs/discuss/209564/Java-Heap-Concise
 */
package com.zea7ot.leetcode.lvl4.lc0954

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach1MinHeap {
    fun canReorderDoubled(nums: IntArray): Boolean {
        if (nums.sum() % 3 != 0) return false

        val minHeap = PriorityQueue<Int>(compareBy { abs(it) })
        for (num in nums) minHeap.offer(num)

        while (minHeap.isNotEmpty()) {
            val num = minHeap.poll()
            if (!minHeap.remove(num * 2)) return false
        }

        return true
    }
}