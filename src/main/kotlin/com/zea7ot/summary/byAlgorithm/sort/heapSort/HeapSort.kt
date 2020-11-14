/**
 * Time Complexity:     O(`totalNums` * lg(`totalNums`))
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://algorithms.tutorialhorizon.com/heap-sort-java-implementation/
 *  https://www.geeksforgeeks.org/heap-sort/
 */
package com.zea7ot.summary.byAlgorithm.sort.heapSort

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class HeapSort {
    fun sort(nums: IntArray) {
        val totalNums = nums.size

        // to build the heap
        for (idx in totalNums / 2 - 1 downTo 0) {
            heapify(idx, nums, totalNums)
        }

        // to extract the max element from the heap one by one
        // to replace it with the last element in the array
        for (idx in totalNums - 1 downTo 0) {
            swap(0, idx, nums)

            // to call the max heapify on the reduced heap
            heapify(0, nums, idx)
        }
    }

    private fun heapify(idx: Int, nums: IntArray, heapSize: Int) {
        var largestIdx = idx
        val leftChildIdx = 2 * idx + 1
        val rightChildIdx = 2 * idx + 2

        if (leftChildIdx < heapSize && nums[leftChildIdx] > nums[largestIdx]) {
            largestIdx = leftChildIdx
        }

        if (rightChildIdx < heapSize && nums[rightChildIdx] > nums[largestIdx]) {
            largestIdx = rightChildIdx
        }

        if (largestIdx != idx) {
            swap(idx, largestIdx, nums)

            // to recursively call to heapify the sub-tree
            heapify(largestIdx, nums, heapSize)
        }
    }

    private fun swap(idx1: Int, idx2: Int, nums: IntArray) {
        val temp = nums[idx1]
        nums[idx1] = nums[idx2]
        nums[idx2] = temp
    }
}