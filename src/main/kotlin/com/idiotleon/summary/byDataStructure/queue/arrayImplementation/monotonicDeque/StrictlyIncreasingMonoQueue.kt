/**
 * @author: Leon
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * to find the minimum in the given sliding window of length `k`
 *
 * References:
 *  Paid Course, 91min: https://www.acwing.com/video/15/
 */
package com.idiotleon.summary.byDataStructure.queue.arrayImplementation.monotonicDeque

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class StrictlyIncreasingMonoQueue {
    private companion object {
        private const val DATA_RANGE = 1e6.toInt() + 7
    }

    private val deque = Array<Int?>(DATA_RANGE) { null }
    private val nums = IntArray(DATA_RANGE) { 0 }
    private var idxHead = 0
    private var idxTail = -1

    fun main() {
        val nInputs = readLine()!!.toInt()

        for (inputIdx in 0 until nInputs) {
            nums[inputIdx] = readLine()!!.toInt()
        }

        val k = readLine()!!.toInt()

        for (idx in 0 until nInputs) {

            if (idxHead <= idxTail && idx - k + 1 > deque[idxHead]!!) ++idxHead

            while (idxHead <= idxTail && nums[deque[idxTail]!!] >= nums[idx]) --idxTail

            deque[++idxTail] = idx

            if (idx >= k - 1) println(nums[deque[idxHead]!!])
        }
    }
}