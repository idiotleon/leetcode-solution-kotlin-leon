/**
 * https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
 *
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/print-immutable-linked-list-in-reverse/discuss/603644/All-Java-solutions-(Including-Follow-ups)-with-FULL-explanations
 */
package com.zea7ot.leetcode.lvl3.lc1265.followups.followup0

import com.zea7ot.leetcode.lvl3.lc1265.FakeImmutableListNode
import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun printLinkedListInReverse(head: FakeImmutableListNode?) {
        if (head == null) return

        var end: FakeImmutableListNode? = null

        while (head != end) {
            var cur = head
            while (cur!!.getNext() != end) {
                cur = cur.getNext()
            }
            cur.printValue()
            end = cur
        }
    }
}