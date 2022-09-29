package com.an7one.leetcode.lvl3.lc0365

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

/**
 * @author: Leon
 * https://leetcode.com/problems/water-and-jug-problem/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/water-and-jug-problem/discuss/83716/Java-Programmatic-Solution-BFS-without-GCD
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun canMeasureWater(x: Int, y: Int, z: Int): Boolean {
        if (z < 0 || z > x + y) return false

        val queue = ArrayDeque<Int>().also {
            it.addLast(0)
        }

        val seen = HashSet<Int>().also {
            it.add(0)
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val n = queue.removeFirst()

                if (n + x <= x + y && seen.add(n + x)) {
                    queue.addLast(n + x)
                }

                if (n + y <= x + y && seen.add(n + y)) {
                    queue.addLast(n + y)
                }


                if (n - x >= 0 && seen.add(n - x)) {
                    queue.addLast(n - x)
                }

                if (n - y >= 0 && seen.add(n - y)) {
                    queue.addLast(n - y)
                }

                if (seen.contains(z)) return true
            }
        }

        return false
    }
}