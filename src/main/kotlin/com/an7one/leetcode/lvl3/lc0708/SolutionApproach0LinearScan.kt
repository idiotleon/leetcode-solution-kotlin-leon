/**
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/discuss/163141/Share-my-concise-JAVA-one-pass-solution/209124
 *  https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/discuss/163141/Share-my-concise-JAVA-one-pass-solution
 */
package com.an7one.leetcode.lvl3.lc0708

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun insert(head: Node?, insertVal: Int): Node {
        if (head == null) {
            val node = Node(insertVal)
            node.next = node
            return node
        }

        var prev: Node? = head
        var cur: Node? = head.next

        while (cur != head) {
            val prevVal = prev!!.`val`
            val curVal = cur!!.`val`

            if (insertVal == prevVal
                || (insertVal in (prevVal + 1)..curVal)
                || (prevVal in (curVal + 1) until insertVal)
                || (curVal in (insertVal + 1) until prevVal)
            )
                break

            prev = cur
            cur = cur.next
        }

        val node = Node(insertVal)
        prev!!.next = node
        node.next = cur

        return head
    }
}