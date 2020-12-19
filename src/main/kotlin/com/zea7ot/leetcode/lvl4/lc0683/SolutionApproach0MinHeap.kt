/**
 * https://leetcode.com/problems/k-empty-slots/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/k-empty-slots/discuss/107948/Iterate-over-time-vs.-iterate-over-position
 */
package com.zea7ot.leetcode.lvl4.lc0683

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MinHeap {
    fun kEmptySlots(bulbs: IntArray, k: Int): Int {
        val nBulbs = bulbs.size
        var ans = nBulbs + 1

        val days = IntArray(nBulbs) { 0 }
        for (idx in bulbs.indices) {
            days[bulbs[idx] - 1] = idx + 1
        }

        val minHeap = PriorityQueue<Int>(compareBy { days[it] })

        var hi = 0
        while (hi < nBulbs) {
            val lo = hi - (k + 1)

            while (minHeap.isNotEmpty() && minHeap.peek() <= lo) minHeap.poll()

            if (lo >= 0 && (minHeap.isEmpty() || days[minHeap.peek()] > maxOf(days[lo], days[hi]))) {
                ans = minOf(ans, maxOf(days[lo], days[hi]))
            }

            minHeap.offer(hi)

            ++hi
        }

        return if (ans > nBulbs) -1 else ans
    }
}