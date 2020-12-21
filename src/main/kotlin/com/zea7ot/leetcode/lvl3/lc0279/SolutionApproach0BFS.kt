/**
 * https://leetcode.com/problems/perfect-squares/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/perfect-squares/discuss/71488/Summary-of-4-different-solutions-(BFS-DP-static-DP-and-mathematics)/73744
 */
package com.zea7ot.leetcode.lvl3.lc0279

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun numSquares(n: Int): Int {
        val queue = LinkedList<Int>().also { it.offer(0) }
        val seen = HashSet<Int>().also { it.add(0) }

        // 1-indexed
        var steps = 1

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val curValue = queue.poll()

                var num = 1
                while (num * num <= n) {
                    val nextValue = curValue + num * num

                    if (nextValue == n) return steps

                    // to prune here
                    if (nextValue > n) {
                        ++num
                        break
                    }

                    if (seen.add(nextValue)) {
                        queue.offer(nextValue)
                    }

                    ++num
                }
            }

            ++steps
        }

        return steps
    }
}