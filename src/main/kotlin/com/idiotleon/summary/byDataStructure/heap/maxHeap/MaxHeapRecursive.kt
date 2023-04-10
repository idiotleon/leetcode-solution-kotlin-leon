/**
 * @author: Leon
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * This is NOT a BST
 *
 * References:
 *  https://youtu.be/OhKC1HxVnd8?t=370
 */
package com.idiotleon.summary.byDataStructure.heap.maxHeap

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class MaxHeapRecursive {
    fun buildHeap(nums: IntArray) {
        val nNums = nums.size
        for (idx in nNums / 2 downTo 0) {
            maxHeapify(idx, nNums, nums)
        }
    }

    private fun maxHeapify(idx: Int, heapCapacity: Int, nums: IntArray) {
        // to initialize the largest as the root
        var idxMax = idx
        val idxLeftChild = idx * 2 + 1
        val idxRightChild = idx * 2 + 2

        // if the left child is larger than the largest so far
        if (idxLeftChild < heapCapacity && nums[idxLeftChild] > nums[idxMax]) {
            idxMax = idxLeftChild
        }

        // if the right child is larger than the largest so far
        if (idxRightChild < heapCapacity && nums[idxRightChild] > nums[idxMax]) {
            idxMax = idxRightChild
        }

        // if the largest is not the root
        if (idxMax != idx) {
            val swap = nums[idx]
            nums[idx] = nums[idxMax]
            nums[idxMax] = swap

            // to recursively heapify the affected subtree
            maxHeapify(idxMax, heapCapacity, nums)
        }
    }
}