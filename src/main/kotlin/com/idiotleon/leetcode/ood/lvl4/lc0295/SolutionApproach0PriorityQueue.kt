package com.idiotleon.leetcode.ood.lvl4.lc0295

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/find-median-from-data-stream/discuss/74047/JavaPython-two-heap-solution-O(log-n)-add-O(1)-find/77111
 */
@Suppress(UNUSED)
class SolutionApproach0PriorityQueue {
    private val lo = PriorityQueue<Int> { a, b -> b.compareTo(a) }
    private val hi = PriorityQueue<Int>()

    fun addNum(num: Int) {
        lo.add(num)
        hi.add(lo.poll())

        if (lo.size < hi.size) {
            lo.offer(hi.poll())
        }
    }

    fun findMedian(): Double {
        return if (lo.size == hi.size) {
            lo.peek() / 2.0 + hi.peek() / 2.0
        } else {
            lo.peek() / 1.0
        }
    }
}