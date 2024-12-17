package com.idiotleon.leetcode.lvl2.lc3264

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 */
@Suppress(UNUSED)
class Solution0MinHeap {
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        val nNums = nums.size
        val minHeap = PriorityQueue<Node>(nNums) { a, b ->
            if (a.num == b.num) {
                a.idx.compareTo(b.idx)
            } else {
                a.num.compareTo(b.num)
            }
        }.also {
            for ((idx, num) in nums.withIndex()) {
                it.offer(Node(num, idx))
            }
        }

        for (count in 0 until k) {
            val (num, idx) = minHeap.poll()
            minHeap.offer(Node(num * multiplier, idx))
        }

        val ans = IntArray(nNums) { 0 }
        while (minHeap.isNotEmpty()) {
            val (num, idx) = minHeap.poll()
            ans[idx] = num
        }

        return ans
    }

    private data class Node(val num: Int, val idx: Int)
}