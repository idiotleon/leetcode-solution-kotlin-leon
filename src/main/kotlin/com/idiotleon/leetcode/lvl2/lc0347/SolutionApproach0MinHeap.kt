package com.idiotleon.leetcode.lvl2.lc0347

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap

/**
 * @author: Leon
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Time Complexity:     O(`nNums` * lg(`k`))
 * Space Complexity:    O(`nNums`)
 */
@Suppress(UNUSED)
class SolutionApproach0MinHeap {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // not used
        // val nNums = nums.size
        val ans = IntArray(k)
        // sanity check
        if (nums.isEmpty()) {
            return ans
        }

        val numToFreq = HashMap<Int, Int>().also {
            for (num in nums) {
                it[num] = (it[num] ?: 0) + 1
            }
        }

        val minHeap = PriorityQueue<Int> { a, b -> (numToFreq[a] ?: 0).compareTo(numToFreq[b] ?: 0) }
        for ((num, _) in numToFreq) {
            minHeap.offer(num)

            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        var idx = k - 1
        while (minHeap.isNotEmpty()) {
            ans[idx--] = minHeap.poll()
        }

        return ans
    }
}