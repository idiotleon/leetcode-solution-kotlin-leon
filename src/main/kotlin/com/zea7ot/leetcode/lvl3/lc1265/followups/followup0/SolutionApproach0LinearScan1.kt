/**
 * https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
 *
 * Time Complexity:     O(`len` ^ 2)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/print-immutable-linked-list-in-reverse/discuss/4
 */
package com.zea7ot.leetcode.lvl3.lc1265.followups.followup0

import com.zea7ot.leetcode.lvl3.lc1265.FakeImmutableListNode
import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun printLinkedListInReverse(head: FakeImmutableListNode?) {
        val len = getLen(head)
        for (idx in len - 1 downTo 0) {
            printNthNode(idx, head)
        }
    }

    private fun printNthNode(n: Int, head: FakeImmutableListNode?) {
        var node = head
        for (idx in 0 until n) {
            node = node!!.getNext()
        }

        node!!.printValue()
    }

    private fun getLen(head: FakeImmutableListNode?): Int {
        if (head == null) return 0
        var node = head
        var len = 0
        while (node != null) {
            ++len
            node = node.getNext()
        }

        return len
    }
}