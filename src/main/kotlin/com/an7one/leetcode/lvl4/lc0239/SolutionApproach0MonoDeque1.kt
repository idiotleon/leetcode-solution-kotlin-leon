package com.an7one.leetcode.lvl4.lc0239

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * the `deque` is used to save indexes, instead of actual values
 *
 * References:
 *  http://zxi.mytechroad.com/blog/heap/leetcode-239-sliding-window-maximum/
 */
@Suppress(UNUSED)
class SolutionApproach0MonoDeque1 {
    @OptIn(ExperimentalStdlibApi::class)
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val nNums = nums.size
        val ans = IntArray(nNums - k + 1)
        var idx = 0

        val deque = ArrayDeque<Int>()

        for (i in nums.indices) {
            if (deque.isNotEmpty() && i - deque.first() >= k) deque.removeFirst()

            while (deque.isNotEmpty() && nums[deque.last()] < nums[i]) {
                deque.removeLast()
            }

            deque.addLast(i)

            if (i >= k - 1) {
                ans[idx++] = nums[deque.first()]
            }
        }

        return ans
    }
}