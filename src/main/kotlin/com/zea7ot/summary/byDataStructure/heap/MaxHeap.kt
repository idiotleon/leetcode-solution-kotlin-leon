/**
 * References:
 *  https://medium.com/@ankur.singh4012/implementing-max-heap-in-java-ea368dadd273
 */
package com.zea7ot.summary.byDataStructure.heap

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class MaxHeap(initialCapacity: Int) {
    private var capacity = initialCapacity
    private var curSize = 0
    private var heap = IntArray(capacity) { 0 }

    fun add(item: Int) {
        ensureCapacity()
        heap[curSize] = item
        ++curSize
        heapifyUp()
    }

    fun peek(): Int {
        if (curSize == 0) throw NoSuchElementException()
        return heap[0]
    }

    fun poll(): Int {
        if (curSize == 0) throw NoSuchElementException()
        val max = heap[0]
        heap[0] = heap[curSize - 1]
        --curSize
        heapifyDown()
        return max
    }

    private fun heapifyUp() {
        var idx = curSize - 1
        while (hasParent(idx) && getParent(idx) < heap[idx]) {
            swap(getParentIdx(idx), idx)
            idx = getParentIdx(idx)
        }
    }

    private fun heapifyDown() {
        var idx = 0

        while (hasLeftChild(idx)) {
            var smallestChildIdx = getLeftChildIdx(idx)

            if (hasRightChild(idx) && getRightChild(idx) < getLeftChild(idx)) {
                smallestChildIdx = getRightChildIdx(idx)
            }

            if (heap[idx] < heap[smallestChildIdx]) {
                swap(idx, smallestChildIdx)
            } else break

            idx = smallestChildIdx
        }
    }

    private fun getLeftChildIdx(parentIdx: Int) = 2 * parentIdx + 1
    private fun getRightChildIdx(parentIdx: Int) = 2 * parentIdx + 2
    private fun getParentIdx(childIdx: Int) = (childIdx - 1) / 2
    private fun hasLeftChild(idx: Int) = getLeftChildIdx(idx) < capacity
    private fun hasRightChild(idx: Int) = getRightChildIdx(idx) < capacity
    private fun hasParent(idx: Int) = getParentIdx(idx) >= 0

    private fun getLeftChild(parentIdx: Int) = heap[getLeftChildIdx(parentIdx)]
    private fun getRightChild(parentIdx: Int) = heap[getRightChildIdx(parentIdx)]
    private fun getParent(childIdx: Int) = heap[getParentIdx(childIdx)]

    private fun ensureCapacity() {
        if (curSize == capacity) {
            heap = heap.copyOf(capacity * 2)
            capacity *= 2
        }
    }

    private fun swap(idx1: Int, idx2: Int) {
        val temp = heap[idx1]
        heap[idx1] = heap[idx2]
        heap[idx2] = temp
    }

}