/**
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 *
 * Time Complexity:     O(`nHeights` * lg(`ladders`))
 * Space Complexity:    O(`ladders`)
 *
 * References:
 *  https://leetcode.com/problems/furthest-building-you-can-reach/discuss/918373/O(nlogn)-Greedy-approach-using-a-min-heap-to-maintain-the-num(ladders)-of-largest-gaps.
 *  https://leetcode.com/problems/furthest-building-you-can-reach/discuss/918515/JavaC%2B%2BPython-Priority-Queue
 */
package com.zea7ot.leetcode.lvl3.lc1642

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        val nHeights = heights.size
        var bricks = bricks

        val minHeap = PriorityQueue<Int>()

        for (idx in 1 until nHeights) {
            val curDiff = heights[idx] - heights[idx - 1]
            // to skip the current building if it is not taller than the previous one
            if (curDiff <= 0) continue

            minHeap.offer(curDiff)
            // to use bricks for the smallest gap
            if (minHeap.size > ladders) bricks -= minHeap.poll()
            if (bricks < 0) return idx - 1
        }

        return nHeights - 1
    }
}