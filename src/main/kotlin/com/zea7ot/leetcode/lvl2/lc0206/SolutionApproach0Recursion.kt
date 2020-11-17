/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 *
 * References:
 *  https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/183356/Java-O(n)-solution-with-super-detailed-explanation-and-illustration
 *  https://leetcode.com/problems/binary-tree-upside-down/discuss/49406/Java-recursive-(O(logn)-space)-and-iterative-solutions-(O(1)-space)-with-explanation-and-figure/156816
 */
package com.zea7ot.leetcode.lvl2.lc0206

import com.zea7ot.leetcode.utils.dataStructure.linkedList.ListNode

class SolutionApproach0Recursion {
    fun reverseList(head: ListNode?) = dfs(head)

    private fun dfs(node: ListNode?): ListNode? {
        if (node?.next == null) return node

        val newHead = dfs(node.next)

        node.next!!.next = node
        node.next = null

        return newHead
    }
}