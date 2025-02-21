package com.idiotleon.leetcode.lvl3.lc0061

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.linkedList.ListNode

/**
 * @author: Leon
 * https://leetcode.com/problems/rotate-list/
 *
 * Time Complexity:     O(`k`) + O(L) ~ O(max(`k`, L))
 * Space Complexity:    O(1)
 *
 * TLEed
 *
 * Reference:
 * https://leetcode.com/problems/rotate-list/discuss/22726/Anyone-solve-the-problem-without-counting-the-length-of-List/22235
 */
@Suppress(UNUSED)
class Solution1TwoPointers {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        // sanity check
        if (head == null) {
            return head
        }

        var fast = head
        var slow = head

        for (i in 0 until k) {
            fast = if (fast?.next == null) {
                head
            } else {
                fast.next
            }
        }

        while (fast?.next != null) {
            fast = fast.next
            slow = slow?.next
        }

        val dummy = ListNode(-1)
        fast?.next = head
        dummy.next = slow?.next
        slow?.next = null

        return dummy.next
    }
}