package com.an7one.leetcode.lvl3.lc0846

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/hand-of-straights/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@Suppress(UNUSED)
class SolutionApproach0TreeMapWithDeque {
    fun isNStraightHand(cards: IntArray, W: Int): Boolean {
        val freqs = TreeMap<Int, Int>()
        for (card in cards) {
            freqs[card] = (freqs[card] ?: 0) + 1
        }

        // to keep track of groups that are open
        val deque = ArrayDeque<Int>()
        var prevCard = -1
        var open = 0

        for ((card, freq) in freqs) {
            if (open > 0 && card > prevCard + 1 || open > freq) return false

            deque.addLast(freq - open)
            prevCard = card
            open = freq

            if (deque.size == W) open -= deque.removeFirst()
        }

        return open == 0
    }
}