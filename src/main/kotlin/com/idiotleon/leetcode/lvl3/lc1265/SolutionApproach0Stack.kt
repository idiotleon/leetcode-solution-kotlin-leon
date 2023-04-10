/**
 * https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 *
 * References:
 *  https://leetcode.com/problems/print-immutable-linked-list-in-reverse/discuss/436647/Jave-Solution-including-Follow-Up
 */
package com.idiotleon.leetcode.lvl3.lc1265

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack {
    fun printLinkedListInReverse(head: FakeImmutableListNode?) {
        if (head == null) return
        val stack = LinkedList<FakeImmutableListNode>()
        var node = head
        while (node != null) {
            stack.push(node)
            node = node.getNext()
        }

        while (stack.isNotEmpty()) {
            stack.pop().printValue()
        }
    }
}