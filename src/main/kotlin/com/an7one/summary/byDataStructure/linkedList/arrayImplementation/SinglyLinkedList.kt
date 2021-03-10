/**
 * @author: Leon
 *
 * References:
 *  Paid Course, 17min: https://www.acwing.com/video/15/
 */
package com.an7one.summary.byDataStructure.linkedList.arrayImplementation

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SinglyLinkedList {
    private companion object {
        private const val DATA_RANGE = 1e6.toInt() + 7
    }

    private var idx = 0 // always to point at the tail node
    private var head = 0
    private val curNodeValues = Array<Int?>(DATA_RANGE) { null }
    private val nextNodeIndexes = Array<Int?>(DATA_RANGE) { null }

    /**
     * to insert a new node right after the `head` node
     *
     * Time Complexity:     O(1)
     * Space Complexity:    O(1)
     */
    fun insertToHead(newValue: Int) {
        curNodeValues[idx] = newValue
        // to point at what `head` points at
        nextNodeIndexes[idx] = head
        head = idx
        ++idx
    }

    /**
     * to insert a new node right after the `kIdx`-th node
     *
     * Time Complexity:     O(1)
     * Space Complexity:    O(1)
     */
    fun insertAfterKthNode(newValue: Int, kIdx: Int) {
        curNodeValues[idx] = newValue
        nextNodeIndexes[idx] = nextNodeIndexes[kIdx]
        nextNodeIndexes[kIdx] = idx
        ++idx
    }

    /**
     * the remove the node right after `kIdx`-th node
     *
     * Time Complexity:     O(1)
     * Space Complexity:    O(1)
     */
    fun removeAfterKthNode(kIdx: Int) {
        if (kIdx == 0) head = nextNodeIndexes[head]!!
        else nextNodeIndexes[kIdx] = nextNodeIndexes[nextNodeIndexes[kIdx]!!]
    }
}