package com.idiotleon.leetcode.lvl3.lc0846

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/hand-of-straights/
 *
 * Time Complexity:     O(DISTINCT * lg(DISTINCT) + O(DISTINCT * W)
 *   DISTINCT, the distinct card/element in `cards`
 *
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/hand-of-straights/discuss/135598/C%2B%2BJavaPython-O(MlogM)-Complexity
 */
@Suppress(UNUSED)
class SolutionApproach0TreeMap {
    fun isNStraightHand(cards: IntArray, W: Int): Boolean {
        val freqs = TreeMap<Int, Int>()
        for (card in cards) {
            freqs[card] = (freqs[card] ?: 0) + 1
        }

        for ((card, freq) in freqs) {
            if (freq == 0) continue
            for (i in W - 1 downTo 0) {
                val expectedCard = card + i
                if ((freqs[expectedCard] ?: 0) < freq) return false

                freqs[expectedCard] = (freqs[expectedCard] ?: 0) - freq
            }
        }

        return true
    }
}