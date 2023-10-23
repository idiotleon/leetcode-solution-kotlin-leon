package com.idiotleon.leetcode.ood.lvl6.lc0460

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/lfu-cache/
 *
 * Time Complexity:
 *  get:    O(1)
 *  put:    O(1)
 *
 * Space Complexity:    O(`capacity`)
 *
 * Reference:
 * https://leetcode.com/problems/lfu-cache/discuss/94547/Java-O(1)-Solution-Using-Two-HashMap-and-One-DoubleLinkedList
 */
@Suppress(UNUSED)
class SolutionApproach0DoublyLinkedList(private val capacity: Int) {
    // DLL: Doubly Linked List
    private val freqToDLL = hashMapOf<Int, DoublyLinkedList>()
    private val valueToNode = hashMapOf<Int, DLLNode>()

    private var size = 0
    private var min = 0

    fun get(key: Int): Int {
        valueToNode[key]?.let {
            update(it)
            return it.value
        }

        return -1
    }

    fun put(key: Int, value: Int) {
        if (capacity == 0) {
            return
        }

        if (valueToNode[key] != null) {
            val node = valueToNode[key]
            node?.value = value
            update(node!!)
        } else {
            val node = DLLNode(key)
            node.value = value
            valueToNode[key] = node

            if (size == capacity) {
                // to remove the last DLL
                freqToDLL[min]?.let { dll ->
                    valueToNode.remove(dll.removeLast()!!.key)
                    --size
                }
            }

            ++size
            min = 1
            val newList = freqToDLL[node.count] ?: DoublyLinkedList()
            newList.addFirst(node)
            freqToDLL[node.count] = newList
        }
    }

    private fun update(node: DLLNode) {
        // to deal with the old DLL
        freqToDLL[node.count]?.let {
            it.remove(node)

            if (node.count == min && it.isEmpty()) {
                ++min
            }
        }

        ++node.count

        val newList = freqToDLL[node.count] ?: DoublyLinkedList()
        newList.addFirst(node)
        freqToDLL[node.count] = newList
    }

    private data class DoublyLinkedList(
        val dummyHead: DLLNode = DLLNode(-1),
        val dummyTail: DLLNode = DLLNode(-1),
    ) {
        var size: Int = 0

        init {
            dummyHead.next = dummyTail
            dummyTail.prev = dummyHead
        }

        fun addFirst(node: DLLNode) {
            val next = dummyHead.next
            dummyHead.next = node
            node.prev = dummyHead
            node.next = next
            next?.prev = node

            ++size
        }

        fun removeLast(): DLLNode? {
            if (size > 0) {
                dummyTail.prev?.let {
                    remove(it)
                    return it
                }
            }

            return null
        }

        fun remove(node: DLLNode) {
            val next = node.next
            val prev = node.prev

            prev?.next = next
            next?.prev = prev

            --size
        }

        fun isEmpty(): Boolean {
            return size == 0
        }
    }

    private data class DLLNode(val key: Int) {
        var value = 0
        var count = 1
        var prev: DLLNode? = null
        var next: DLLNode? = null
    }
}