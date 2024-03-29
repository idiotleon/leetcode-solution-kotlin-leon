package com.idiotleon.leetcode.lvl2.lc0024

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.linkedList.ListNode

/**
 * @author: Leon
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Time Complexity:     O(len)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
private class SolutionApproach0LinearScan {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        val dummy = ListNode(-1)
        dummy.next = head

        var prev = dummy
        var cur = head

        while (cur?.next != null) {
            val first = cur
            val second = cur.next

            prev.next = second
            first.next = second!!.next
            second.next = first

            prev = first
            cur = first.next
        }

        return dummy.next
    }
}