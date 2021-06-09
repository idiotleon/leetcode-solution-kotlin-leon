/**
 * https://leetcode.com/problems/jump-game-vi/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 *  https://leetcode.com/problems/jump-game-vi/discuss/978462/C%2B%2B-DP-%2B-Monoqueue-O(n)
 */
package com.an7one.leetcode.lvl4.lc1696

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproachDPWMonoDeque {
    fun maxResult(nums: IntArray, k: Int): Int {
        // not used
        // val nNums = nums.size

        var score = 0
        val deque = LinkedList<Int>()

        for (idx in nums.indices.reversed()) {
            score = nums[idx] + if (deque.isEmpty()) 0 else nums[deque.peekFirst()]

            while (deque.isNotEmpty() && score > nums[deque.peekLast()]) {
                deque.pollLast()
            }

            deque.offerLast(idx)

            if (deque.peekFirst() >= idx + k)
                deque.pollFirst()

            nums[idx] = score
        }

        return score
    }
}