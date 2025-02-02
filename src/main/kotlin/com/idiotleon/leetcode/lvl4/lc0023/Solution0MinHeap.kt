package com.idiotleon.leetcode.lvl4.lc0023

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.linkedList.ListNode
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * Time Complexity:     (`nLists` & lg(`nLists`))
 * Space Complexity:    O(`nLists`)
 */
@Suppress(UNUSED)
class Solution0MinHeap {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val nLists = lists.size

        val minHeap = PriorityQueue<ListNode> { a, b -> a.`val`.compareTo(b.`val`) }.also {
            for (list in lists) {
                if (list != null) {
                    it.offer(list)
                }
            }
        }

        val dummy = ListNode(-1)
        var prev: ListNode? = dummy
        while (minHeap.isNotEmpty()) {
            val top = minHeap.poll()
            top.next?.let { minHeap.offer(it) }

            prev?.next = top
            prev = prev?.next
        }

        return dummy.next
    }
}