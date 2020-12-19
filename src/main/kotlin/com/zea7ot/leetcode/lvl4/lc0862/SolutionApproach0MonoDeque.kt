/**
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/143726/C%2B%2BJavaPython-O(N)-Using-Deque
 */
package com.zea7ot.leetcode.lvl4.lc0862

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoDeque {
    fun shortestSubarray(nums: IntArray, K: Int): Int {

        val totalNums = nums.size
        val prefixSums = IntArray(totalNums + 1)
        for (idx in 0 until totalNums) {
            prefixSums[idx + 1] = prefixSums[idx] + nums[idx]
        }

        val deque = LinkedList<Int>()
        var shortest = totalNums + 1

        for (idx in 0..totalNums) {
            while (deque.isNotEmpty() && prefixSums[idx] - prefixSums[deque.peekFirst()] >= K) {
                shortest = minOf(shortest, idx - deque.pollFirst())
            }

            while (deque.isNotEmpty() && prefixSums[deque.peekLast()] > prefixSums[idx]) {
                deque.pollLast()
            }

            deque.offer(idx)
        }

        return if (shortest == totalNums + 1) -1 else shortest
    }
}