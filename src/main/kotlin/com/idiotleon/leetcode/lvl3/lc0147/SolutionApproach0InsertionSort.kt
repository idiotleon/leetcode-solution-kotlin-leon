package com.idiotleon.leetcode.lvl3.lc0147

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.linkedList.ListNode

/**
 * @author: Leon
 * https://leetcode.com/problems/insertion-sort-list/
 *
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0InsertionSort {
    fun insertionSortList(head: ListNode?): ListNode? {
        if (head == null) return null

        val dummy = ListNode(-1)
        var prev = dummy
        var cur = head

        while (cur != null) {
            val next = cur.next

            if (prev.`val` >= cur.`val`) {
                prev = dummy
            }

            while (prev.next != null && prev.next!!.`val` < cur.`val`) {
                prev = prev.next!!
            }

            cur.next = prev.next
            prev.next = cur
            cur = next
        }

        return dummy.next
    }
}