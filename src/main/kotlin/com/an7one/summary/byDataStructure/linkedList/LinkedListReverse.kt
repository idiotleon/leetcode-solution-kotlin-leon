package com.an7one.summary.byDataStructure.linkedList

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.linkedList.ListNode

@Suppress(UNUSED)
class LinkedListReverse {
    /**
     * to reverse the linked list from `start` to `end` both ends inclusive (wherever possible).
     *  if the reaching the tail/end before `hi`, it stills reverses the linked list till the tail/end
     *
     * @param start: the start of the range to be reversed in the linked list, which is guaranteed to exist on the linked list
     * @param end: the end of the range to be reversed in the linked list
     */
    fun reverseInRangeIterative(start: ListNode?, end: ListNode?): ListNode? {
        var prev: ListNode? = null
        var cur = start

        while (cur != null && cur != end) {
            val next = cur.next

            cur.next = prev
            prev = cur
            cur = next
        }

        return prev
    }
}