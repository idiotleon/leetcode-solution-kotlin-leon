/**
 * https://leetcode.com/problems/water-and-jug-problem/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/water-and-jug-problem/discuss/83716/Java-Programmatic-Solution-BFS-without-GCD
 */
package com.zea7ot.leetcode.lvl3.lc1015

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun canMeasureWater(x: Int, y: Int, z: Int): Boolean {
        if (z < 0 || z > x + y) return false

        val seen = HashSet<Int>()
        val queue = LinkedList<Int>()
        queue.offer(0)

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val n = queue.poll()

                if (n + x <= x + y && seen.add(n + x)) {
                    queue.offer(n + x)
                }

                if (n + y <= x + y && seen.add(n + y)) {
                    queue.offer(n + y)
                }


                if (n - x >= 0 && seen.add(n - x)) {
                    queue.offer(n - x)
                }

                if (n - y >= 0 && seen.add(n - y)) {
                    queue.offer(n - y)
                }

                if (seen.contains(z)) return true
            }
        }

        return false
    }
}