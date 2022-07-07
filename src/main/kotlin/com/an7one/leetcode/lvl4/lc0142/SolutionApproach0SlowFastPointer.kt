package com.an7one.leetcode.lvl4.lc0142

import com.an7one.leetcode.util.Constant
import com.an7one.leetcode.util.dataStructure.linkedList.ListNode

/**
 * @author: Leon
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
@Suppress(Constant.Annotation.UNUSED)
class SolutionApproach0SlowFastPointer {
    fun detectCycle(head: ListNode?): ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head
        var cur: ListNode? = head
        while (fast?.next != null) {
            fast = fast.next!!.next
            slow = slow!!.next
            if (slow == fast) {
                while (cur != slow) {
                    cur = cur!!.next;
                    slow = slow!!.next;
                }
                return slow
            }
        }
        return null
    }
}