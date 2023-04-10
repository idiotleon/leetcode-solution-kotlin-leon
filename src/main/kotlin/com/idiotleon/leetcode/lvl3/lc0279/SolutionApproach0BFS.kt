package com.idiotleon.leetcode.lvl3.lc0279

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.collections.ArrayDeque
import kotlin.collections.HashSet

/**
 * @author: Leon
 * https://leetcode.com/problems/perfect-squares/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/perfect-squares/discuss/71488/Summary-of-4-different-solutions-(BFS-DP-static-DP-and-mathematics)/73744
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun numSquares(n: Int): Int {
        val queue = ArrayDeque<Int>().also { it.addLast(0) }
        val seen = HashSet<Int>().also { it.add(0) }

        // 1-indexed
        var steps = 1

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val curValue = queue.removeFirst()

                var num = 1
                while (num * num <= n) {
                    val nextValue = curValue + num * num

                    if (nextValue == n) return steps

                    // to prune here
                    if (nextValue > n) {
                        ++num
                        break
                    }

                    if (seen.add(nextValue)) queue.removeFirst()

                    ++num
                }
            }

            ++steps
        }

        return steps
    }
}