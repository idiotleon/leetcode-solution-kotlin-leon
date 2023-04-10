package com.idiotleon.leetcode.lvl3.lc0950

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/
 *
 * Time Complexity:     O(`nCards`)
 * Space Complexity:    O(`nCards`)
 */
@Suppress(UNUSED)
class SolutionApproach0QueueSimulation {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        val nCards = deck.size

        deck.sort()
        val queue = ArrayDeque<Int>().also {
            for (cardIdx in 0 until nCards) {
                it.addLast(cardIdx)
            }
        }

        val ans = IntArray(nCards) { 0 }
        for (idx in deck.indices) {
            ans[queue.removeFirst()] = deck[idx]
            queue.addLast(queue.removeFirst())
        }

        return ans
    }
}