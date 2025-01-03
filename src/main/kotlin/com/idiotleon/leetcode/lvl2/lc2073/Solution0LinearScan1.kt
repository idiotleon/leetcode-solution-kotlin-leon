package com.idiotleon.leetcode.lvl2.lc2073

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/time-needed-to-buy-tickets/
 *
 * Time Complexity:     O(`nTickets`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan1 {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        val nTickets = tickets.size
        val kBuy = tickets[k]
        var needed = 0
        for ((idx, ticket) in tickets.withIndex()) {
            if (idx <= k) {
                needed += if (ticket >= kBuy) {
                    kBuy
                } else {
                    ticket
                }
            } else {
                needed += if (ticket >= kBuy - 1) {
                    kBuy - 1
                } else {
                    ticket
                }
            }
        }

        return needed
    }
}