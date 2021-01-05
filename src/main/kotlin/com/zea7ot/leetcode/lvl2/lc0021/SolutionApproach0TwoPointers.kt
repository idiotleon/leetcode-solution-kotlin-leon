/**
 * @author: Leon
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Time Complexity:     O(max(len1, len2))
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0021

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.linkedList.ListNode

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummyHead = ListNode(-1)
        var prev = dummyHead

        var l1 = l1
        var l2 = l2

        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                prev.next = l1
                l1 = l1.next
            } else {
                prev.next = l2
                l2 = l2.next
            }

            prev = prev.next!!
        }

        if (l1 != null) prev.next = l1
        if (l2 != null) prev.next = l2

        return dummyHead.next
    }
}