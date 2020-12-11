/**
 * https://leetcode.com/problems/max-value-of-equation/
 *
 * Time Complexity:     O(`totalPoints`)
 * Space Complexity:    O(`totalPoints`)
 *
 * a sliding window approach with a monotonic deque
 *
 * References:
 *  https://leetcode.com/problems/max-value-of-equation/discuss/709231/JavaPython-Priority-Queue-and-Deque-Solution-O(N)
 */
package com.zea7ot.leetcode.lvl4.lc1499

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun findMaxValueOfEquation(points: Array<IntArray>, k: Int): Int {
        // not used
        // val totalPoints = points.size

        val deque = LinkedList<Node>()

        var max = Int.MIN_VALUE
        for (point in points) {
            while (deque.isNotEmpty() && point[0] - deque.peekFirst().xCoor > k) {
                deque.removeFirst();
            }

            if (deque.isNotEmpty()) {
                max = maxOf(max, deque.peekFirst().variance + point[0] + point[1])
            }

            while (deque.isNotEmpty() && point[1] - point[0] > deque.peekLast().variance) {
                deque.removeLast()
            }

            deque.addLast(Node(point[1] - point[0], point[0]))
        }

        return max
    }

    private data class Node(val variance: Int, val xCoor: Int)
}