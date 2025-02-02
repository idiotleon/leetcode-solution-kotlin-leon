package com.idiotleon.leetcode.lvl3.lc0019

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.linkedList.ListNode

/**
 * @author: Leon
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0HighLowPointers {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(-1)
        dummy.next = head
        var hi: ListNode? = dummy
        var lo: ListNode? = dummy
        for (idx in 1..n + 1) {
            hi = hi?.next
        }

        while (hi != null) {
            hi = hi.next
            lo = lo?.next
        }

        lo?.next = lo?.next?.next

        return dummy.next
    }
}