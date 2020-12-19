/**
 * https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 *
 * Time Complexity:     O(`totalSticks` * lg(`totalSticks`))
 * Space Complexity:    O(`totalSticks`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-cost-to-connect-sticks/discuss/365849/JavaPython-3-Greedy-%2B-PriorityQueue-w-analysis.
 *  https://leetcode.com/problems/minimum-cost-to-connect-sticks/discuss/365865/Python-Greedy-Solution/661580
 */
package com.zea7ot.leetcode.lvl2.lc1167

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun connectSticks(sticks: IntArray): Int {
        // not used
        // val totalSticks = sticks.size

        val minHeap = PriorityQueue<Int>()
        for (stick in sticks) minHeap.offer(stick)

        var totalCost = 0
        while (minHeap.size > 1) {
            val cost = minHeap.poll() + minHeap.poll()
            totalCost += cost
            minHeap.offer(cost)
        }

        return totalCost
    }
}