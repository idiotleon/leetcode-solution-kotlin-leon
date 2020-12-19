/**
 * https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 *
 * Time Complexity:     O(`totalSticks` * lg(`totalSticks`))
 * Space Complexity:    O(`totalSticks`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-cost-to-connect-sticks/discuss/486834/Accepted-C-(without-pq)-solution%3A-Easy-to-understand
 */
package com.zea7ot.leetcode.lvl2.lc1167

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Greedy1 {
    fun connectSticks(sticks: IntArray): Int {
        // not used
        // val totalSticks = sticks.size

        var totalCost = 0

        sticks.sort()
        val sticksQueue = LinkedList<Int>()
        for (stick in sticks) sticksQueue.offer(stick)
        val connectedQueue = LinkedList<Int>()

        while (sticksQueue.size + connectedQueue.size > 1) {
            val cost = getCost(sticksQueue, connectedQueue) + getCost(sticksQueue, connectedQueue)
            connectedQueue.offer(cost)
            totalCost += cost
        }

        return totalCost
    }

    private fun getCost(sticks: LinkedList<Int>, connected: LinkedList<Int>): Int {
        return when {
            sticks.isEmpty() -> connected.poll()
            connected.isEmpty() -> sticks.poll()
            else -> if (sticks.peek() < connected.peek()) sticks.poll()
            else connected.poll()
        }
    }
}