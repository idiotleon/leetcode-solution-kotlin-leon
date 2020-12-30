/**
 *
 * References:
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/FenwickTree.java
 */
package com.zea7ot.summary.byDataStructure.tree.binaryIndexedTree

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class BinaryIndexedTree(private val nums: IntArray) {
    private val nNums = nums.size
    private val capacity = nNums + 1
    private val binaryIndexedTree = IntArray(capacity) { 0 }

    init {
        createBinaryIndexedTree()
    }

    /**
     * to get the prefix sum from 0(inclusive) to `index`(inclusive)
     * to keep summing up till `idx`
     */
    fun getSum(index: Int): Int {
        // 0-indexed, from 1-indexed
        var idx = index - 1
        var sum = 0
        while (idx > 0) {
            sum += binaryIndexedTree[idx]
            idx = getParent(idx)
        }
        return sum
    }

    private fun createBinaryIndexedTree() {
        for (idx in nums.indices) {
            // 1-indexed
            updateBinaryIndexedTree(nums[idx], 1 + idx)
        }
    }

    private fun updateBinaryIndexedTree(value: Int, index: Int) {
        var idx = index
        while (idx < capacity) {
            binaryIndexedTree[idx] += value
            idx = getNext(idx)
        }
    }

    /**
     * to get the next of `idx`
     *
     * `idx and -idx`, to get the rightmost `1`
     * complement code
     */
    private fun getNext(idx: Int) = idx + (idx and -idx)

    /**
     * to get the parent of `idx`
     *
     * `idx and -idx`, to get the rightmost `1`
     * complement code
     */
    private fun getParent(idx: Int) = idx - (idx and -idx)
}