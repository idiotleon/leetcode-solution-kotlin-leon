package com.zea7ot.leetcode.lvl3.lc0950

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0QueueSimulation {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        val totalCards = deck.size

        deck.sort()
        val queue = LinkedList<Int>().also {
            for (cardIdx in 0 until totalCards) {
                it.offer(cardIdx)
            }
        }

        val ans = IntArray(totalCards) { 0 }
        for (idx in deck.indices) {
            ans[queue.poll()] = deck[idx]
            queue.add(queue.poll())
        }

        return ans
    }
}