/**
 * https://leetcode.com/problems/constrained-subsequence-sum/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/constrained-subsequence-sum/discuss/597751/JavaC++Python-O(N)-Decreasing-Deque/675105
 *  https://leetcode.com/problems/constrained-subsequence-sum/discuss/597751/JavaC++Python-O(N)-Decreasing-Deque
 */
package com.idiotleon.leetcode.lvl4.lc1425

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoDeque {
    fun constrainedSubsetSum(nums: IntArray, k: Int): Int {

        val totalNums = nums.size
        val sums = IntArray(totalNums)
        var sum = nums[0]

        val deque = LinkedList<Int>()

        for (idx in 0 until totalNums) {
            sums[idx] = nums[idx]
            if (deque.isNotEmpty()) {
                sums[idx] += sums[deque.peek()]
            }
            sum = maxOf(sum, sums[idx])

            if (deque.isNotEmpty() && deque.peekFirst() < (idx - k + 1)) {
                deque.pollFirst()
            }

            while (deque.isNotEmpty() && sums[deque.peekLast()] <= sums[idx]) {
                deque.pollLast()
            }

            if (sums[idx] > 0) {
                deque.offer(idx)
            }
        }

        return sum
    }
}