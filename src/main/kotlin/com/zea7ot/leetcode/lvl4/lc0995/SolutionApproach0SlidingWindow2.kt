/**
 * https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`K`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/239284/C%2B%2B-greedy-stack-and-O(1)-memory
 *  nimum-number-of-k-consecutive-bit-flips/discuss/238609/JavaC%2B%2BPython-One-Pass-and-O(1)-Space
 */
package com.zea7ot.leetcode.lvl4.lc0995

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow2 {
    fun minKBitFlips(nums: IntArray, K: Int): Int {
        // not used
        // val totalNums = nums.size

        var flipsCounter = 0

        val deque = LinkedList<Int>()

        for (idx in nums.indices) {
            if (nums[idx] != if (deque.size % 2 == 1) 0 else 1) {
                ++flipsCounter
                deque.addLast(idx + K - 1)
            }

            if (deque.isNotEmpty() && deque.peekFirst() <= idx) deque.removeFirst()
        }

        return if (deque.isEmpty()) flipsCounter else -1
    }
}