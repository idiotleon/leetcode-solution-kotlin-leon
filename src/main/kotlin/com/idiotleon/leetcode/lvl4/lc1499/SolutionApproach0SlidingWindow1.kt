package com.idiotleon.leetcode.lvl4.lc1499

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/max-value-of-equation/
 *
 * Time Complexity:     O(`nPoints` * lg(`nPoints`))
 * Space Complexity:    O(`nPoints`)
 *
 * a sliding window approach with a max heap/PQ
 *
 * Reference:
 * https://leetcode.com/problems/max-value-of-equation/discuss/709231/JavaPython-Priority-Queue-and-Deque-Solution-O(N)
 */
@Suppress(UNUSED)
class SolutionApproach0SlidingWindow1 {
    fun findMaxValueOfEquation(points: Array<IntArray>, k: Int): Int {
        // not used
        // val nPoints = points.size

        val maxHeap = PriorityQueue<Node>(compareBy({ -it.variance }, { it.xCoor }))

        var max = Int.MIN_VALUE

        for (point in points) {
            while (maxHeap.isNotEmpty() && point[0] - maxHeap.peek().xCoor > k) {
                maxHeap.poll()
            }

            if (maxHeap.isNotEmpty()) {
                max = maxOf(max, maxHeap.peek().variance + point[0] + point[1])
            }

            maxHeap.offer(Node(point[1] - point[0], point[0]))
        }

        return max
    }

    private data class Node(val variance: Int, val xCoor: Int)
}