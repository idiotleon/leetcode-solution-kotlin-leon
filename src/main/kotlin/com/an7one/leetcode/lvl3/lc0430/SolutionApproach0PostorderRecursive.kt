package com.an7one.leetcode.lvl3.lc0430

import com.an7one.leetcode.util.Constant

/**
 * @author: Leon
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * Time Complexity:   O()
 * Space Complexity:  O()
 */
class SolutionApproach0PostorderRecursive {
    private var prev: Node? = null

    @Suppress(Constant.Annotation.UNUSED)
    fun flatten(head: Node?): Node? {
        if (head == null) return head;

        flatten(head.next)
        flatten(head.child)

        head.next = prev
        prev?.let {
            it.prev = head
        }

        head.child = null
        prev = head
        return head
    }
}