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
class Solution0LinearScan {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        val nTickets = tickets.size
        val kBuy = tickets[k]
        var needed = 0
        for ((idx, ticket) in tickets.withIndex()) {
            needed += if (idx <= k) {
                minOf(kBuy, ticket)
            } else {
                minOf(kBuy - 1, ticket)
            }
        }

        return needed
    }
}