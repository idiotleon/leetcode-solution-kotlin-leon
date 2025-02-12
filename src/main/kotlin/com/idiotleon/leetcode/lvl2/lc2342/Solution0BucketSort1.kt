package com.idiotleon.leetcode.lvl2.lc2342

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@Suppress(UNUSED)
class Solution0BucketSort1 {
    fun maximumSum(nums: IntArray): Int {
        val nNums = nums.size

        val sumToNums = HashMap<Int, PriorityQueue<Int>>().also { map ->
            for (num in nums) {
                map.getOrPut(getSum(num)) { PriorityQueue<Int>(nNums, compareBy { -it }) }.offer(num)
            }
        }

        var max = -1
        for ((_, maxHeap) in sumToNums) {
            if (maxHeap.size > 1) {
                val sum = maxHeap.poll() + maxHeap.poll()
                max = maxOf(max, sum)
            }
        }

        return max
    }

    private fun getSum(num: Int): Int {
        var num = num
        var sum = 0
        while (num > 0) {
            val digit = num % 10
            sum += digit
            num /= 10
        }
        return sum
    }
}