/**
 * https://leetcode.com/problems/insertion-sort-list/
 *
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0147

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.linkedList.ListNode

@Suppress(UNUSED)
class SolutionApproach0InsertionSort {
    fun insertionSortList(head: ListNode?): ListNode? {
        if (head == null) return head

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