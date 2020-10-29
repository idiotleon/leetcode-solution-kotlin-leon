/**
 * @author: Leon
 * https://leetcode.com/problems/lru-cache/
 *
 * Time Complexities:
 *  initialization:     O(1)
 *  `get()`:            O(1)
 *  `put()`:            O(1)
 *
 * Space Complexity:    O(`capacity`)
 */
package com.zea7ot.leetcode.ood.lvl3.lc0146

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DoublyLinkedList(capacity: Int) {
    private val dll = DoublyLinkedList(capacity)

    fun get(key: Int) = dll.get(key)

    fun put(key: Int, value: Int) = dll.put(key, value)

    private class DoublyLinkedList(private val capacity: Int) {
        private val map = HashMap<Int, DLLNode>()

        private val dummyHead = DLLNode(-1, -1)
        private val dummyTail = DLLNode(-1, -1)
        private var len: Int

        init {
            dummyHead.next = dummyTail
            dummyTail.prev = dummyHead

            this.len = 0
        }

        fun get(key: Int): Int {
            map[key]?.let {
                moveToHead(it)
                return it.value
            }

            return -1
        }

        fun put(key: Int, value: Int) {
            if (map[key] == null) {
                val newNode = DLLNode(key, value)
                map[key] = newNode
                addFirst(newNode)
            } else {
                val node = map[key]!!
                node.value = value
                moveToHead(node)
            }
        }

        private fun addFirst(node: DLLNode) {
            val next = dummyHead.next
            node.prev = dummyHead
            dummyHead.next = node

            node.next = next
            next?.prev = node

            if (++len > capacity) removeLast()
        }

        private fun moveToHead(node: DLLNode) {
            removeNode(node)
            addFirst(node)
        }

        private fun removeLast(): DLLNode? {
            dummyTail.prev?.let {
                if (it == dummyHead) return null
                val key = it.key
                map.remove(key)
                return removeNode(it)
            }

            return null
        }

        private fun removeNode(node: DLLNode): DLLNode {
            val next = node.next
            val prev = node.prev

            prev?.next = next
            next?.prev = prev

            --len

            return node
        }
    }

    private class DLLNode(val key: Int, var value: Int) {
        var prev: DLLNode? = null
        var next: DLLNode? = null
    }
}