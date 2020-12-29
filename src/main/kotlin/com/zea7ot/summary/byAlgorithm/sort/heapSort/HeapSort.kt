/**
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://algorithms.tutorialhorizon.com/heap-sort-java-implementation/
 *  https://www.geeksforgeeks.org/heap-sort/
 */
package com.zea7ot.summary.byAlgorithm.sort.heapSort

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class HeapSort {
    fun sort(nums: IntArray) {
        val nNums = nums.size

        // to build the heap
        for (idx in nNums / 2 - 1 downTo 0) {
            maxHeapify(idx, nums, nNums)
        }

        // to extract the max element from the heap one by one
        // to replace it with the last element in the array
        for (idx in nums.indices.reversed()) {
            swap(0, idx, nums)

            // to call the max heapify on the reduced heap
            maxHeapify(0, nums, idx)
        }
    }

    private fun maxHeapify(idx: Int, nums: IntArray, heapSize: Int) {
        var idxMax = idx
        val idxLeftChild = 2 * idx + 1
        val idxRightChild = 2 * idx + 2

        if (idxLeftChild < heapSize && nums[idxLeftChild] > nums[idxMax]) {
            idxMax = idxLeftChild
        }

        if (idxRightChild < heapSize && nums[idxRightChild] > nums[idxMax]) {
            idxMax = idxRightChild
        }

        if (idxMax != idx) {
            swap(idx, idxMax, nums)

            // to recursively call to heapify the sub-tree
            maxHeapify(idxMax, nums, heapSize)
        }
    }

    private fun swap(idx1: Int, idx2: Int, nums: IntArray) {
        val temp = nums[idx1]
        nums[idx1] = nums[idx2]
        nums[idx2] = temp
    }
}