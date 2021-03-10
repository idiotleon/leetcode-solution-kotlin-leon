/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/discuss/609771/JavaC%2B%2BPython-Deques-O(N)
 *  https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/discuss/609743/Java-Detailed-Explanation-Sliding-Window-Deque-O(N)
 */
package com.an7one.leetcode.lvl4.lc1438

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoDeque {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val nNums = nums.size

        val maxDeque = LinkedList<Int>()
        val minDeque = LinkedList<Int>()

        var lo = 0
        var hi = 0

        while (hi < nNums) {
            while (maxDeque.isNotEmpty() && nums[hi] > maxDeque.peekLast()) {
                maxDeque.pollLast()
            }

            while (minDeque.isNotEmpty() && nums[hi] < minDeque.peekLast()) {
                minDeque.pollLast()
            }

            maxDeque.add(nums[hi])
            minDeque.add(nums[hi])

            if (maxDeque.peek() - minDeque.peek() > limit) {
                if (maxDeque.peek() == nums[lo]) maxDeque.poll()

                if (minDeque.peek() == nums[lo]) minDeque.poll()

                ++lo
            }


            ++hi
        }

        return hi - lo
    }
}