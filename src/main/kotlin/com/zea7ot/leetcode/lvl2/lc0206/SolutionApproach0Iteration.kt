/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/183356/Java-O(n)-solution-with-super-detailed-explanation-and-illustration
 *  https://leetcode.com/problems/binary-tree-upside-down/discuss/49406/Java-recursive-(O(logn)-space)-and-iterative-solutions-(O(1)-space)-with-explanation-and-figure/156816
 */
package com.zea7ot.leetcode.lvl2.lc0206

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.linkedList.ListNode

@Suppress(UNUSED)
class SolutionApproach0Iteration {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var cur = head

        while (cur != null) {
            val next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }

        return prev
    }
}