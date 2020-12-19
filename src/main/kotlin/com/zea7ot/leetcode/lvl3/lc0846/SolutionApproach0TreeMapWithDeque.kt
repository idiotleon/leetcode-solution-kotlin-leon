package com.zea7ot.leetcode.lvl3.lc0846

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0TreeMapWithDeque {
    fun isNStraightHand(cards: IntArray, W: Int): Boolean {
        val freqs = TreeMap<Int, Int>()
        for (card in cards) {
            freqs[card] = (freqs[card] ?: 0) + 1
        }

        // to keep track of groups that are open
        val deque = LinkedList<Int>()
        var prevCard = -1
        var open = 0

        for ((card, freq) in freqs) {
            if (open > 0 && card > prevCard + 1 || open > freq) return false

            deque.addLast(freq - open)
            prevCard = card
            open = freq
            if (deque.size == W) {
                open -= deque.pollFirst()
            }
        }

        return open == 0
    }
}