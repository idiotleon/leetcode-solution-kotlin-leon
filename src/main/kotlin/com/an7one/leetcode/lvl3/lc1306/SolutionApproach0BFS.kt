/**
 * @author: Leon
 * https://leetcode.com/problems/jump-game-iii/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 */
package com.an7one.leetcode.lvl3.lc1306

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun canReach(nums: IntArray, start: Int): Boolean {
        val totalNums = nums.size

        val queue = LinkedList<Int>().also {
            it.offer(start)
        }

        val seen = hashSetOf(start)

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                if (nums[cur] == 0) return true

                (cur + nums[cur]).let {
                    if (it in 0 until totalNums && seen.add(it)) {
                        queue.offer(it)
                    }
                }

                (cur - nums[cur]).let {
                    if (it in 0 until totalNums && seen.add(it)) {
                        queue.offer(it)
                    }
                }
            }
        }

        return false
    }
}