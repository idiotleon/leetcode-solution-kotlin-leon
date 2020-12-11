package com.zea7ot.leetcode.lvl4.lc1438

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoDeque {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val totalNums = nums.size

        val maxDeque = LinkedList<Int>()
        val minDeque = LinkedList<Int>()

        var lo = 0
        var hi = 0

        while (hi < totalNums) {
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