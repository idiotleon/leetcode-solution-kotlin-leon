/**
 * https://leetcode.com/problems/design-a-leaderboard/
 *
 * Time Complexities:
 *      `addScore()`:       O(N * lg(N))
 *      `top()`:            O()
 *      `reset()`:          O()
 *
 * Space Complexity:        O(N)
 *
 * References:
 *  https://leetcode.com/problems/design-a-leaderboard/discuss/428412/Java-Map-and-TreeSet-(O(logN))
 */
package com.zea7ot.leetcode.ood.lvl3.lc1244

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0TreeMap1 {
    private val map = HashMap<Int, Int>()
    private val freqs = TreeMap<Int, Int>(compareByDescending { it })

    fun addScore(playerId: Int, score: Int) {
        var newScore = score
        if (map.containsKey(playerId)) {
            newScore += map[playerId]!!
            reset(playerId)
        }

        map[playerId] = newScore
        freqs[newScore] = 1 + (freqs[newScore] ?: 0)
    }

    fun top(K: Int): Int {
        var k = 0
        var sum = 0

        outer@ for ((score, freq) in freqs) {
            inner@ for (repeat in 0 until freq) {
                sum += score
                ++k
                if (k == K) break@outer
            }
        }

        return sum
    }

    fun reset(playerId: Int) {
        if (map.containsKey(playerId)) {
            val prevScore = map[playerId]!!
            freqs[prevScore] = (freqs[prevScore] ?: 1) - 1
            freqs.remove(prevScore, 0)
            map.remove(playerId)
        }
    }
}