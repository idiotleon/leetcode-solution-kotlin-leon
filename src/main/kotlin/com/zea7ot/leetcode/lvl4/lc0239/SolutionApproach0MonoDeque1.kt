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
class SolutionApproach0MonoDeque1 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val totalNums = nums.size
        val ans = IntArray(totalNums - k + 1)
        var idx = 0

        val deque = LinkedList<Int>()

        for (i in nums.indices) {
            if (deque.isNotEmpty() && i - deque.peekFirst() >= k) deque.removeFirst()

            while (deque.isNotEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast()
            }

            deque.addLast(i);

            if (i >= k - 1) {
                ans[idx++] = nums[deque.peekFirst()]
            }
        }

        return ans
    }
}