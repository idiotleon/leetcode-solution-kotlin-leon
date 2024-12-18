package com.idiotleon.leetcode.lvl4.lc1438

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/discuss/609771/JavaC%2B%2BPython-Deques-O(N)
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/discuss/609743/Java-Detailed-Explanation-Sliding-Window-Deque-O(N)
 */
@Suppress(UNUSED)
class SolutionApproach0MonoDeque {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val nNums = nums.size

        val maxDeque = ArrayDeque<Int>(nNums)
        val minDeque = ArrayDeque<Int>(nNums)

        var lo = 0
        var hi = 0

        while (hi < nNums) {
            while (maxDeque.isNotEmpty() && nums[hi] > maxDeque.last()) {
                maxDeque.removeLast()
            }

            while (minDeque.isNotEmpty() && nums[hi] < minDeque.last()) {
                minDeque.removeLast()
            }

            maxDeque.add(nums[hi])
            minDeque.add(nums[hi])

            if (maxDeque.last() - minDeque.last() > limit) {
                if (maxDeque.last() == nums[lo]) {
                    maxDeque.removeLast()
                }

                if (minDeque.last() == nums[lo]) {
                    minDeque.removeLast()
                }

                ++lo
            }

            ++hi
        }

        return hi - lo
    }
}