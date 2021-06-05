/**
 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
 *
 * Time Complexity:     O(`sizeW` * lg(`sizeW`)) + O(`sizeW` * lg(k`))
 * Space Complexity:    O(`sizeW`)
 *
 * Reference:
 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers/discuss/141768/Detailed-explanation-O(NlogN)
 */
package com.an7one.leetcode.lvl5.lc0857

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun mincostToHireWorkers(qualities: IntArray, wages: IntArray, k: Int): Double {
        val sizeW = qualities.size
        val workers = Array(sizeW) { idx ->
            Worker(
                wages[idx].toDouble() / qualities[idx].toDouble(),
                qualities[idx].toDouble()
            )
        }.also {
            it.sortBy { w -> w.ratio }
        }

        var minCost: Double = Double.MAX_VALUE
        var sumQua = 0.0

        val maxHeap = PriorityQueue<Double>(compareBy { -it })
        for ((ratio, quality) in workers) {
            sumQua += quality
            maxHeap.add(quality)

            if (maxHeap.size > k)
                sumQua -= maxHeap.poll()

            if (maxHeap.size == k)
                minCost = minOf(minCost, sumQua * ratio)
        }

        return minCost
    }

    private data class Worker(val ratio: Double, val quality: Double)
}