/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * the `deque` is used to save indexes, instead of actual values
 *
 * References:
 *  http://zxi.mytechroad.com/blog/heap/leetcode-239-sliding-window-maximum/
 */
package com.zea7ot.leetcode.lvl4.lc0239

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoDeque {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val nNums = nums.size
        val ans = IntArray(nNums - k + 1)
        // sanity check
        if (nums.isEmpty()) return ans

        val deque = LinkedList<Int>()
        var idx = 0

        for (i in nums.indices) {
            // when the size of the `deque` is larger than `k`
            while (deque.isNotEmpty() && deque.peekFirst() < i - k + 1) {
                deque.removeFirst()
            }

            // when there is a new large number coming in from the last/tail
            while (deque.isNotEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast()
            }

            deque.addLast(i)

            if (i >= k - 1) {
                ans[idx++] = nums[deque.peekFirst()]
            }
        }

        return ans
    }
}