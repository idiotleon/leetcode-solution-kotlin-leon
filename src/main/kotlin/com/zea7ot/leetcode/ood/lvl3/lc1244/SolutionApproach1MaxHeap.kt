/**
 * https://leetcode.com/problems/design-a-leaderboard/
 *
 * Time Complexities:
 *      `addScore()`:       O(1)
 *      `top()`:            O(N * lg(N))
 *      `reset():`          O(1)
 *
 *  Space Complexity:       O(N)
 *
 * References:
 *   https://leetcode.com/problems/design-a-leaderboard/discuss/422314/Simple-Java-Solution-using-HashMap-and-PriorityQueue
 */
package com.zea7ot.leetcode.ood.lvl3.lc1244

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach1MaxHeap {
    private val map = HashMap<Int, Int>()

    fun addScore(playerId: Int, score: Int) {
        map[playerId] = score + (map[playerId] ?: 0)
    }

    fun top(K: Int): Int {
        val maxHeap = PriorityQueue<Player>(compareBy { -it.score })
        for ((id, score) in map) {
            maxHeap.offer(Player(id, score))
        }

        var res = 0
        var k = 0

        while (k < K && maxHeap.isNotEmpty()) {
            val player = maxHeap.poll()
            res += player.score
            ++k
        }

        return res
    }

    fun reset(playerId: Int) {
        map[playerId] = 0
    }

    private data class Player(val playerId: Int, val score: Int)
}