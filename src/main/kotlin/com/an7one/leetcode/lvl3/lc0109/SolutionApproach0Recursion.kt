package com.an7one.leetcode.lvl3.lc0109

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.linkedList.ListNode
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(lg(L))
 *
 * a top-down approach
 */
@Suppress(UNUSED)
class SolutionApproach0Recursion {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        return dfs(head)
    }

    private fun dfs(head: ListNode?): TreeNode? {
        if (head == null) return null

        val mid = findMid(head)
        val root = TreeNode(mid.`val`)
        if (head == mid) return root

        root.left = dfs(head)
        root.right = dfs(mid.next)

        return root
    }

    private fun findMid(head: ListNode): ListNode {
        var prev: ListNode? = head
        var slow = head
        var fast: ListNode? = head

        while (fast?.next != null) {
            prev = slow
            slow = slow.next!!
            fast = fast.next!!.next
        }

        prev?.next = null

        return slow
    }
}