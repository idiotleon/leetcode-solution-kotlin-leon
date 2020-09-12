/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(K)
 */
package com.zea7ot.lc.lvl2.lc0973

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MaxHeap {
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        val ans = Array(K) { IntArray(2) }
        // sanity check
        if (points.isEmpty()) return ans

        val maxHeap = PriorityQueue<IntArray> { a, b
            ->
            (b[0].toLong() * b[0].toLong() + b[1].toLong() * b[1].toLong()).compareTo(a[0].toLong() * a[0].toLong() + a[1].toLong() * a[1].toLong())
        }

        for (point in points) {
            maxHeap.offer(point)
            if (maxHeap.size > K)
                maxHeap.poll()
        }

        var idx = K - 1
        while (maxHeap.isNotEmpty())
            ans[idx--] = maxHeap.poll()

        return ans
    }
}