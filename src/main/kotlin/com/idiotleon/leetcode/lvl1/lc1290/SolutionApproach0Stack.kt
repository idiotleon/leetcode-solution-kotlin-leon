package com.idiotleon.leetcode.lvl1.lc1290

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.linkedList.ListNode
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
@Suppress(UNUSED)
class SolutionApproach0Stack {
    fun getDecimalValue(head: ListNode?): Int {
        val stack = ArrayDeque<ListNode>()

        var node = head
        while (node != null) {
            stack.addLast(node)
            node = node.next
        }

        var res = 0
        var steps = 0

        while (stack.isNotEmpty()) {
            val top = stack.removeLast()
            val value = top.`val`
            res = res or (value shl steps++)
        }

        return res
    }
}