/**
 * https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 *
 * References:
 *  https://leetcode.com/problems/print-immutable-linked-list-in-reverse/discuss/436647/Jave-Solution-including-Follow-Up
 */
package com.zea7ot.leetcode.lvl3.lc1265

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Postorder {
    fun printLinkedListInReverse(head: FakeImmutableListNode?) {
        if (head == null) return
        postorder(head)
    }

    private fun postorder(node: FakeImmutableListNode?) {
        if (node == null) return
        postorder(node.getNext())
        node.printValue()
    }
}