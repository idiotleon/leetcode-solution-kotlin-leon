package com.idiotleon.leetcode.lvl3.lc1019

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.linkedList.ListNode

/**
 * @author: Leon
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 *
 * Time Complexity:     O(L)
 *  L, length of the linked list
 * Space Complexity:    O(L)
 *  L, length of the linked list
 *
 * Review
 * 1. This is a typical monotonic stack problem, because of monotonicity and next
 * 2. What makes this problem special is that it is a LinkedList,
 * instead of an array,
 * where the total length/size is unknown without a full traversal.
 * This is a good inspiration that,
 * for the monotonic stack approach,
 * it only looks back.
 *
 * Reference:
 * https://leetcode.com/problems/next-greater-node-in-linked-list/discuss/265508/JavaC++Python-Next-Greater-Element/256331
 * https://leetcode.com/problems/next-greater-node-in-linked-list/discuss/265508/JavaC%2B%2BPython-Next-Greater-Element
 */
@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun nextLargerNodes(head: ListNode?): IntArray {
        val ans = mutableListOf<Int>()
        val stack = ArrayDeque<Int>()

        var cur = head
        var idx = 0

        while (cur != null) {
            val value = cur.`val`
            while (stack.isNotEmpty() && ans[stack.last()] < value) {
                ans[stack.removeLast()] = value
            }

            ans.add(value)
            stack.addLast(idx)

            cur = cur.next
            ++idx
        }

        while (stack.isNotEmpty()) {
            ans[stack.removeLast()] = 0
        }

        return ans.toIntArray()
    }
}