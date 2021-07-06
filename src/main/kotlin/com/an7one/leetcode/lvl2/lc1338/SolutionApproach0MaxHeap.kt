/**
 * https://leetcode.com/problems/reduce-array-size-to-the-half/
 *
 * Time Complexity:     O(`nNums`) + O(distinct(`nNums`) * lg(distinct(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 *  https://leetcode.com/problems/reduce-array-size-to-the-half/discuss/513773/Java-HashMap-and-Heap
 */
package com.an7one.leetcode.lvl2.lc1338

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0MaxHeap {
    fun minSetSize(nums: IntArray): Int {
        val nNums = nums.size

        val numToFreq = HashMap<Int, Int>()
        for (num in nums) {
            val newFreq = 1 + (numToFreq[num] ?: 0)
            if (newFreq >= nNums / 2)
                return 1
            numToFreq[num] = newFreq
        }

        val maxHeap = PriorityQueue<Int>(compareBy { -it })
        for ((_, freq) in numToFreq) {
            maxHeap.offer(freq)
        }

        var count = 0
        var sumFreq = 0
        while (maxHeap.isNotEmpty()) {
            sumFreq += maxHeap.poll()
            ++count
            if (sumFreq >= nNums / 2)
                return count
        }

        return count
    }
}