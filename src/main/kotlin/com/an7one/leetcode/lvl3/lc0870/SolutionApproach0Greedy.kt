/**
 * https://leetcode.com/problems/advantage-shuffle/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 *  https://leetcode.com/problems/advantage-shuffle/discuss/149822/JAVA-Greedy-6-lines-with-Explanation
 */
package com.an7one.leetcode.lvl3.lc0870

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun advantageCount(nums1: IntArray, nums2: IntArray): IntArray {
        val nNums = nums1.size

        nums1.sort()
        val maxHeap = PriorityQueue<Node>(compareBy { -it.value })

        for ((idx, value) in nums2.withIndex()) {
            maxHeap.offer(Node(value, idx))
        }

        var lo = 0
        var hi = nNums - 1

        val ans = IntArray(nNums) { 0 }

        while (maxHeap.isNotEmpty()) {
            val (value, idx) = maxHeap.poll()
            ans[idx] = if (value < nums1[hi]) nums1[hi--] else nums1[lo++]
        }

        return ans
    }

    private data class Node(val value: Int, val idx: Int)
}