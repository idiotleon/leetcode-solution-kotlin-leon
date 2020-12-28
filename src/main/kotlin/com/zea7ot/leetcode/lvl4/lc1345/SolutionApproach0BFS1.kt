/**
 * https://leetcode.com/problems/jump-game-iv/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/jump-game-iv/discuss/502699/JavaC%2B%2B-BFS-Solution-Clean-code-O(N)
 */
package com.zea7ot.leetcode.lvl4.lc1345

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0BFS1 {
    fun minJumps(nums: IntArray): Int {
        val nNums = nums.size

        val valToIdx = HashMap<Int, HashSet<Int>>()
        for ((idx, value) in nums.withIndex()) {
            valToIdx.getOrPut(value) { hashSetOf() }.add(idx)
        }

        val queue = LinkedList<Int>().also {
            it.offer(0)
        }

        val seen = HashSet<Int>().also {
            it.add(0)
        }

        var steps = 0

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                if (cur == nNums - 1) return steps

                if (cur - 1 >= 0 && seen.add(cur - 1)) queue.offer(cur - 1)
                if (cur + 1 <= nNums - 1 && seen.add(cur + 1)) queue.offer(cur + 1)
                valToIdx[nums[cur]]?.let {
                    for (idx in it) {
                        if (seen.add(idx)) {
                            queue.offer(idx)
                        }
                    }

                    it.clear()
                }
            }

            ++steps
        }

        return -1
    }
}