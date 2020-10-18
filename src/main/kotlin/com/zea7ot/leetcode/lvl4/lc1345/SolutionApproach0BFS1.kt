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

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0BFS1 {
    fun minJumps(nums: IntArray): Int {
        val totalNums = nums.size

        // a map of value to indexes of `nums`
        val idxMap = HashMap<Int, ArrayList<Int>>()
        for (idx in 0 until totalNums) {
            idxMap.getOrPut(nums[idx]) { arrayListOf() }.add(idx)
        }

        val queue = LinkedList<Int>()
        queue.offer(0)

        val seen = hashSetOf(0)

        var steps = 0

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val curIdx = queue.poll()
                if (curIdx == totalNums - 1) return steps

                val hiNext = curIdx + 1
                if (hiNext in 0 until totalNums && seen.add(hiNext)) {
                    queue.offer(hiNext)
                }

                val loNext = curIdx - 1
                if (loNext in 0 until totalNums && seen.add(loNext)) {
                    queue.offer(loNext)
                }

                idxMap[nums[curIdx]]?.let {
                    for (equalValNext in it) {
                        if (!seen.add(equalValNext)) continue
                        queue.offer(equalValNext)
                    }

                    // to save time
                    // there is no need to check visited/seen at all later on
                    it.clear()
                }
            }

            ++steps
        }

        return -1
    }
}