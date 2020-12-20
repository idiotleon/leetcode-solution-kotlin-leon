/**
 * https://leetcode.com/problems/jump-game-vi/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/jump-game-vi/discuss/978462/C%2B%2B-DP-%2B-Greedy-Monoqueue-O(n)
 */
package com.zea7ot.leetcode.lvl3.lc1697

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun maxResult(nums: IntArray, k: Int): Int {
        // not used
        // val nNums = nums.size

        val dp = nums.copyOf()

        val deque = LinkedList<Int>()

        for (idx in dp.indices) {
            val max = if (deque.isEmpty()) 0 else dp[deque.peekFirst()]

            dp[idx] = dp[idx] + max

            while (deque.isNotEmpty() && dp[deque.peekLast()] < dp[idx]) {
                deque.removeLast()
            }

            deque.addLast(idx)

            while (deque.isNotEmpty() && idx - deque.peekFirst() + 1 > k) {
                deque.removeFirst()
            }
        }

        return dp.last()
    }
}