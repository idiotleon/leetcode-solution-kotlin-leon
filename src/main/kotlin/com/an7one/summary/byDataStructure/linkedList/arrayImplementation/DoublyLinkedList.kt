/**
 * @author: Leon
 *
 * References:
 *  Paid Course, 50min: https://www.acwing.com/video/15/
 */
package com.an7one.summary.byDataStructure.linkedList.arrayImplementation

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DoublyLinkedList {
    private companion object {
        private const val DATA_RANGE = 1e6.toInt() + 7
    }

    private var idx: Int
    private val curNodeValues = Array<Int?>(DATA_RANGE) { null }
    private val leftIndexes = Array<Int?>(DATA_RANGE) { null }
    private val rightIndexes = Array<Int?>(DATA_RANGE) { null }

    init {
        rightIndexes[0] = 1
        leftIndexes[1] = 0
        idx = 2
    }

    /**
     * to insert a new node right after the `kIdx`-th node
     *
     * Time Complexity:     O(1)
     * Space Complexity:    O(1)
     */
    fun insertAfterKthNode(newValue: Int, kIdx: Int) {
        curNodeValues[idx] = newValue
        rightIndexes[idx] = rightIndexes[kIdx]
        leftIndexes[idx] = kIdx
        rightIndexes[kIdx] = idx
        leftIndexes[rightIndexes[kIdx]!!] = idx
        ++idx
    }

    /**
     * to remove the `kIdx`-th node
     *
     * Time Complexity:     O(1)
     * Space Complexity:    O(1)
     */
    fun remove(kIdx: Int) {
        rightIndexes[leftIndexes[kIdx]!!] = rightIndexes[kIdx]
        leftIndexes[rightIndexes[kIdx]!!] = leftIndexes[kIdx]
    }
}