/**
 * https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
 *
 * Time Complexity:     O(N * lg(N)), NOT linear time
 * Space Complexity:    O(lg(N))
 *
 * References:
 *  https://leetcode.com/problems/print-immutable-linked-list-in-reverse/discuss/603644/All-Java-solutions-(Including-Follow-ups)-with-FULL-explanations
 */
package com.zea7ot.leetcode.lvl3.lc1265.followups.followup1

import com.zea7ot.leetcode.lvl3.lc1265.FakeImmutableListNode
import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DivideAndConquer2 {
    fun printLinkedListInReverse(head: FakeImmutableListNode?) {
        dfs(head, null)
    }

    private fun dfs(start: FakeImmutableListNode?, end: FakeImmutableListNode?) {
        if (start == null || start == end) return
        if (start.getNext() == end) {
            start.printValue()
            return
        }

        // to get the mid node
        var slow = start
        var fast = start

        while (fast != end && fast!!.getNext() != end) {
            slow = slow!!.getNext()
            fast = fast.getNext()!!.getNext()
        }

        dfs(slow, end)
        dfs(start, slow)
    }
}