/**
 * @author: Leon
 *
 * this is a min heap
 *
 * References:
 *  https://youtu.be/OhKC1HxVnd8?t=781
 */
package com.idiotleon.summary.byDataStructure.heap

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class PriorityQueue(private val capacity: Int) {
    private val queue = IntArray(capacity) { 0 }
    private var size = 0

    fun offer(num: Int): Boolean {
        if (size == capacity) return false

        queue[size] = num
        siftUp(size)
        ++size
        return true
    }

    fun poll(): Int? {
        if (size == 0) return null
        val minValue = queue[0]
        queue[0] = queue[size - 1]
        --size
        if (size > 0) siftDown(0)
        return minValue
    }

    fun peek(): Int? {
        if (size == 0) return null
        return queue[0]
    }

    private fun siftDown(idx: Int) {
        var idxMin = idx
        val idxLeftChild = 2 * idx + 1
        val idxRightChild = 2 * idx + 2

        if (idxLeftChild < size && queue[idxLeftChild] < queue[idxMin]) {
            idxMin = idxLeftChild
        }

        if (idxRightChild < size && queue[idxRightChild] < queue[idxMin]) {
            idxMin = idxRightChild
        }

        if (idxMin != idx) {
            swap(idxMin, idx)
            siftDown(idxMin)
        }
    }

    private fun siftUp(idx: Int) {
        if (idx != 0) {
            val idxParent = (idx - 1) / 2
            if (queue[idxParent] > queue[idx]) {
                swap(idxParent, idx)
            }
        }
    }

    private fun swap(i: Int, j: Int) {
        val swap = queue[i]
        queue[i] = queue[j]
        queue[j] = swap
    }
}