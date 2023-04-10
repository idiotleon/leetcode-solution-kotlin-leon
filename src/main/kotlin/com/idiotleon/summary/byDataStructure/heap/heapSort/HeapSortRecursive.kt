/**
 * @author: Leon
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://youtu.be/OhKC1HxVnd8?t=617
 */
package com.idiotleon.summary.byDataStructure.heap.heapSort

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
private class HeapSortRecursive {
    fun heapSort(nums: IntArray) {
        val nNums = nums.size

        // to build the max heap
        for (idx in nNums / 2 - 1 downTo 0) {
            maxHeapify(idx, nNums, nums)
        }

        // to extract elements one by one from the heap
        // this is similar to `maxHeap.poll()`
        // time complexity:     O(`nNums` * lg(`nNums`))
        for (idx in nums.indices.reversed()) {
            val swap = nums[0]
            nums[0] = nums[idx]
            nums[idx] = swap

            // to call max heapify on the reduced heap
            // time complexity:     O(lg(`nNums`))
            maxHeapify(0, idx, nums)
        }
    }

    private fun maxHeapify(idx: Int, heapSize: Int, nums: IntArray) {
        var idxMax = idx
        val idxLeftChild = idxMax * 2 + 1
        val idxRightChild = idxMax * 2 + 2

        if (idxLeftChild < heapSize && nums[idxMax] < nums[idxLeftChild]) {
            idxMax = idxLeftChild
        }

        if (idxRightChild < heapSize && nums[idxMax] < nums[idxRightChild]) {
            idxMax = idxRightChild
        }

        if (idxMax != idx) {
            val swap = nums[idxMax]
            nums[idxMax] = nums[idx]
            nums[idx] = swap

            maxHeapify(idxMax, heapSize, nums)
        }
    }
}