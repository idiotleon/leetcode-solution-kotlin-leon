/**
 * https://leetcode.com/problems/rotate-list/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 *
 * to link the tail of the list with the head, making it a circle
 *
 * References:
 *  https://leetcode.com/problems/rotate-list/discuss/22751/Clean-Java-Solution-with-Brief-Explanation
 */
package com.zea7ot.leetcode.lvl3.lc0061

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.linkedList.ListNode

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        // sanity check
        if (head == null) return head

        var cur = head
        var len = 1
        while (cur?.next != null) {
            cur = cur.next
            ++len
        }

        // to make the linked list circular
        cur?.next = head

        var copy = head
        for (i in len - k % len downTo 2) {
            copy = copy?.next
        }

        cur = copy?.next

        // to break the linked list
        copy?.next = null

        return cur
    }
}