package com.idiotleon.leetcode.lvl4.lc1696

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/jump-game-vi/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/jump-game-vi/discuss/978462/C%2B%2B-DP-%2B-Monoqueue-O(n)
 */
@Suppress(UNUSED)
class SolutionApproachDPWMonoDeque {
    fun maxResult(nums: IntArray, k: Int): Int {
        // not used
        // val nNums = nums.size

        var score = 0
        val deque = ArrayDeque<Int>()

        for (idx in nums.indices.reversed()) {
            score = nums[idx] + if (deque.isEmpty()) 0 else nums[deque.peekFirst()]

            while (deque.isNotEmpty() && score > nums[deque.peekLast()]) {
                deque.removeLast()
            }

            deque.addLast(idx)

            if (deque.peekFirst() >= idx + k) deque.removeFirst()

            nums[idx] = score
        }

        return score
    }
}