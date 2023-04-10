package com.idiotleon.leetcode.lvl2.lc0021

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.linkedList.ListNode

/**
 * @author: Leon
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Time Complexity:     O(max(len1, len2))
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    private companion object {
        private const val RANGE = 100 + 7
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        var prev: ListNode? = dummy
        var cur1 = list1
        var cur2 = list2
        while (cur1 != null || cur2 != null) {
            val value1 = cur1?.`val` ?: RANGE
            val value2 = cur2?.`val` ?: RANGE
            if (value1 < value2) {
                prev?.next = cur1
                cur1 = cur1?.next
            } else {
                prev?.next = cur2
                cur2 = cur2?.next
            }
            prev = prev?.next
        }
        return dummy.next
    }
}