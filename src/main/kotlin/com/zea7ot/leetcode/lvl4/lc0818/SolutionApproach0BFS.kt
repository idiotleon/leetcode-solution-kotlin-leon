/**
 * https://leetcode.com/problems/race-car/
 *
 * Time Complexity:     O(`target` * lg(`target`))
 * Space Complexity:    O(`target` * lg(`target`))
 *
 * References:
 *  https://leetcode.com/problems/race-car/discuss/124326/Summary-of-the-BFS-and-DP-solutions-with-intuitive-explanation
 */
package com.zea7ot.leetcode.lvl4.lc0818

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun racecar(target: Int): Int {
        val stateStart = State(0, 1)
        val queue = LinkedList<State>().also {
            it.offer(stateStart)
        }

        val seen = HashSet<String>().also {
            it.add(hash(stateStart))
        }

        var steps = 0
        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val (curPos, curSpeed) = queue.poll()

                if (curPos == target) return steps

                val accelerated = State(curPos + curSpeed, curSpeed shl 1)
                if (seen.add(hash(accelerated))
                    && accelerated.position in 0 until (target shl 1)
                ) {
                    queue.offer(accelerated)
                }

                val reversed = State(curPos, if (curSpeed > 0) -1 else 1)
                if (seen.add(hash(reversed))
                    && reversed.position in 0 until (target shl 1)
                ) {
                    queue.offer(reversed)
                }
            }

            ++steps
        }

        return -1
    }

    private fun hash(state: State) = "$state.position#$state.speed"

    private data class State(val position: Int, val speed: Int)
}