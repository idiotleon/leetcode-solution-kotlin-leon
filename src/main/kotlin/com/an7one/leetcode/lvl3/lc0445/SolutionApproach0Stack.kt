package com.an7one.leetcode.lvl3.lc0445

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.linkedList.ListNode
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/add-two-numbers-ii/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
@Suppress(UNUSED)
class SolutionApproach0Stack {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val stack1 = ArrayDeque<Int>()
        var cur = l1
        while (cur != null) {
            stack1.addLast(cur.`val`)
            cur = cur.next
        }

        val stack2 = ArrayDeque<Int>()
        cur = l2
        while (cur != null) {
            stack2.addLast(cur.`val`)
            cur = cur.next
        }

        var carry = 0
        var head: ListNode? = null

        while (stack1.isNotEmpty() || stack2.isNotEmpty() || carry > 0) {
            val num1 = if (stack1.isNotEmpty()) stack1.removeLast() else 0
            val num2 = if (stack2.isNotEmpty()) stack2.removeLast() else 0

            val sum = num1 + num2 + carry
            carry = sum / 10

            val newNode = ListNode(sum % 10)
            newNode.next = head
            head = newNode
        }

        return head
    }
}