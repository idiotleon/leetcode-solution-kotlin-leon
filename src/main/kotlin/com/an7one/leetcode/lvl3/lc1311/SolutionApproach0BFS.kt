/**
 * @author: Leon
 * https://leetcode.com/problems/get-watched-videos-by-your-friends/
 *
 * Time Complexity:     O(`nFriends`)
 * Space Complexity:    O(`nFriends`)
 */
package com.an7one.leetcode.lvl3.lc1311

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun watchedVideosByFriends(
        watchedVideos: List<List<String>>,
        friends: Array<IntArray>,
        id: Int,
        level: Int
    ): List<String> {
        // not used
        // val nFriends = friends.size

        val queue = LinkedList<Int>().also {
            it.offer(id)
        }

        val seen = hashSetOf(id)

        val freqs = HashMap<String, Int>()
        var lvl = 0

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                if (level == lvl) {
                    for (movie in watchedVideos[cur]) {
                        freqs[movie] = (freqs[movie] ?: 0) + 1
                    }
                } else { // pruning here
                    for (next in friends[cur]) {
                        if (!seen.add(next)) continue
                        queue.offer(next)
                    }
                }
            }

            ++lvl
        }

        val ans = freqs.keys.toTypedArray()
        ans.sortWith(compareBy({ freqs[it] ?: 0 }, { it }))
        return ans.toList()
    }
}