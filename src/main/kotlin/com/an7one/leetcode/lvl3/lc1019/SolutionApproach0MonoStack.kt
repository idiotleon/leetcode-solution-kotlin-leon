/**
 * @author: Leon
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 *
 * Time Complexity:     O(L)
 *  L, length of the linked list
 * Space Complexity:    O(L)
 *  L, length of the linked list
 *
 * References:
 *  https://leetcode.com/problems/next-greater-node-in-linked-list/discuss/265508/JavaC++Python-Next-Greater-Element/256331
 *  https://leetcode.com/problems/next-greater-node-in-linked-list/discuss/265508/JavaC%2B%2BPython-Next-Greater-Element
 */
package com.an7one.leetcode.lvl3.lc1019

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.linkedList.ListNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun nextLargerNodes(head: ListNode?): IntArray {
        val ans = mutableListOf<Int>()
        val stack = LinkedList<Int>()

        var cur = head
        var idx = 0

        while (cur != null) {
            val value = cur.`val`
            while (stack.isNotEmpty() && ans[stack.peek()] < value) {
                ans[stack.pop()] = value
            }

            ans.add(value)
            stack.push(idx)

            cur = cur.next
            ++idx
        }

        while (stack.isNotEmpty()) {
            ans[stack.pop()] = 0
        }

        return ans.toIntArray()
    }
}