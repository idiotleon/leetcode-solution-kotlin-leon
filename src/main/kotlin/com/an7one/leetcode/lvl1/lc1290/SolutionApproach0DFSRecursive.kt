package com.an7one.leetcode.lvl1.lc1290

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.linkedList.ListNode

/**
 * @author: Leon
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun getDecimalValue(head: ListNode?): Int {
        return dfs(head).decimal
    }

    private fun dfs(node: ListNode?): Bit {
        if (node == null) return Bit(0, 0)

        val (decimal, bitPos) = dfs(node.next)
        val value = decimal or (node.`val` shl bitPos)
        return Bit(value, 1 + bitPos)
    }

    private data class Bit(val decimal: Int, val bitPos: Int)
}