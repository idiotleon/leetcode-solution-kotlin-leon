package com.idiotleon.leetcode.lvl2.lc0876

import com.idiotleon.leetcode.util.Constant
import com.idiotleon.leetcode.util.dataStructure.linkedList.ListNode

/**
 * @author: Leon
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
@Suppress(Constant.Annotation.UNUSED)
class SolutionApproach0LinearScan {
    fun middleNode(head: ListNode?): ListNode? {
        var len = 1
        var slow = head
        var fast = head
        while(fast != null && fast!!.next != null){
            slow = slow?.next
            fast = fast.next?.next
            ++len
        }
        return slow
    }
}