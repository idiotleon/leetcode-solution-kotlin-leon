package com.idiotleon.leetcode.ood.lvl4.lc0146

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/lru-cache/
 *
 * Time Complexity:
 *  initialization:     O(1)
 *  `get()`:            O(1)
 *  `put()`:            O(1)
 *
 * Space Complexity:    O(`capacity`)
 */
@Suppress(UNUSED)
class Solution0DoublyLinkedList1(private val capacity: Int) {
    private val map = HashMap<Int, Node>()
    private val dll = DoublyLinkedList(capacity)
    private var size = 0

    fun get(key: Int): Int {
        map[key]?.let {
            dll.moveToHead(it)
            return it.value
        }

        return -1
    }

    fun put(key: Int, value: Int) {
        if (map[key] == null) {
            val newNode = Node(key, value)
            map[key] = newNode
            dll.addFirst(newNode)

            if (++size > capacity) {
                dll.removeLast()?.let {
                    map.remove(it.key)
                }
            }
        } else {
            val node = map[key]!!
            node.value = value
            dll.moveToHead(node)
        }
    }

    private class DoublyLinkedList(private val capacity: Int) {
        private val dummyHead = Node(-1, -1)
        private val dummyTail = Node(-1, -1)
        private var len: Int

        init {
            dummyHead.next = dummyTail
            dummyTail.prev = dummyHead

            this.len = 0
        }

        fun moveToHead(node: Node) {
            removeNode(node)
            addFirst(node)
        }

        fun addFirst(node: Node) {
            val next = dummyHead.next
            node.prev = dummyHead
            dummyHead.next = node

            node.next = next
            next?.prev = node
        }

        fun removeLast(): Node? {
            dummyTail.prev?.let {
                if (it == dummyHead) {
                    return null
                }
                return removeNode(it)
            }

            return null
        }

        private fun removeNode(node: Node): Node {
            val next = node.next
            val prev = node.prev

            prev?.next = next
            next?.prev = prev

            --len

            return node
        }
    }

    private class Node(val key: Int, var value: Int, var prev: Node? = null, var next: Node? = null)
}