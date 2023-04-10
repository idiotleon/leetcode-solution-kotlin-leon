package com.idiotleon.leetcode.lvl2.lc0369

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.linkedList.ListNode

/**
 * @author: Leon
 * https://leetcode.com/problems/plus-one-linked-list/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/plus-one-linked-list/discuss/84130/Java-recursive-solution
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun plusOne(head: ListNode?): ListNode? {
        if (dfs(head) == 0) {
            return head
        }

        val newHead = ListNode(1)
        newHead.next = head
        return newHead
    }

    private fun dfs(head: ListNode?): Int {
        if (head == null) return 1

        val carry = dfs(head.next)

        val value = carry + head.`val`
        head.`val` = value % 10
        return value / 10
    }
}