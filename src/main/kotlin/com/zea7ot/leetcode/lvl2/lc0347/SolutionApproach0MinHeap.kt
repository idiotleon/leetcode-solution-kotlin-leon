/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Time Complexity:     O(N * lg(k))
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl2.lc0347

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0MinHeap {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val ans = IntArray(k)
        // sanity check
        if (nums.isEmpty()) return ans

        val freqs = HashMap<Int, Int>()
        for (num in nums)
            freqs[num] = (freqs[num] ?: 0) + 1

        val minHeap = PriorityQueue<Int> { a, b -> (freqs[a] ?: 0).compareTo(freqs[b] ?: 0) }
        for ((num, _) in freqs) {
            minHeap.offer(num)

            if (minHeap.size > k)
                minHeap.poll()
        }

        var idx = k - 1
        while (!minHeap.isEmpty())
            ans[idx--] = minHeap.poll()

        return ans
    }
}