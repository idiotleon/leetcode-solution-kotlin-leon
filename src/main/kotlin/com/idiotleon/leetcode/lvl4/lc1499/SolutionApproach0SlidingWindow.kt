package com.idiotleon.leetcode.lvl4.lc1499

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/max-value-of-equation/
 *
 * Time Complexity:     O(`nPoints`)
 * Space Complexity:    O(`nPoints`)
 *
 * a sliding window approach with a monotonic deque
 *
 * Reference:
 * https://leetcode.com/problems/max-value-of-equation/discuss/709231/JavaPython-Priority-Queue-and-Deque-Solution-O(N)
 */
@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun findMaxValueOfEquation(points: Array<IntArray>, k: Int): Int {
        // not used
        // val nPoints = points.size

        val deque = ArrayDeque<Node>()

        var max = Int.MIN_VALUE
        for (point in points) {
            while (deque.isNotEmpty() && point[0] - deque.first().xCoord > k) {
                deque.removeFirst()
            }

            if (deque.isNotEmpty()) {
                max = maxOf(max, deque.first().variance + point[0] + point[1])
            }

            while (deque.isNotEmpty() && point[1] - point[0] > deque.last().variance) {
                deque.removeLast()
            }

            deque.addLast(Node(point[1] - point[0], point[0]))
        }

        return max
    }

    private data class Node(val variance: Int, val xCoord: Int)
}