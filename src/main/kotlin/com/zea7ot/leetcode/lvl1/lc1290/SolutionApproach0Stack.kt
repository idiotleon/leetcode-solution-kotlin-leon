/**
 * @author: Leon
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.zea7ot.leetcode.lvl1.lc1290

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.linkedList.ListNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack {
    fun getDecimalValue(head: ListNode?): Int {
        val stack = LinkedList<ListNode>()

        var node = head
        while (node != null) {
            stack.push(node)
            node = node.next
        }

        var res = 0
        var steps = 0

        while (stack.isNotEmpty()) {
            val top = stack.pop()
            val value = top.`val`
            res = res or (value shl steps++)
        }

        return res
    }
}