/**
 * https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/
 *
 * Time Complexity:     O((`nNums` ^ 2) * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/discuss/730511/C++-priority_queue-solution/612996
 *  https://youtu.be/6UJEMVmMJDw
 *  https://zxi.mytechroad.com/blog/queue/leetcode-1508-range-sum-of-sorted-subarray-sums/
 */
package com.zea7ot.leetcode.lvl2.lc1509

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MinHeap {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
        val minHeap = PriorityQueue<RangeSum>(compareBy { it.sum }).also {
            for (idx in 0 until n)
                it.offer(RangeSum(nums[idx].toLong(), idx + 1))
        }

        var ans = 0

        for (idx in 1..right) {
            val cur = minHeap.poll()

            if (idx >= left) {
                ans = ((ans + cur.sum) % MOD).toInt()
            }

            if (cur.idx < n) {
                val nextSum = cur.sum + nums[cur.idx]
                val nextIdx = cur.idx + 1

                minHeap.offer(RangeSum(nextSum, nextIdx))
            }
        }

        return ans
    }

    private data class RangeSum(val sum: Long, val idx: Int)
}