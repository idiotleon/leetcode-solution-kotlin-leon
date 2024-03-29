package com.idiotleon.leetcode.lvl3.lc1367

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.linkedList.ListNode
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/linked-list-in-binary-tree/
 *
 * Time Complexity:     O(L + N) ~ O(max(L, N))
 *  L, amount of nodes of the linked list
 *  N, amount of nodes of the tree
 *
 * Space Complexity:    O(H + L) ~ O(max(H, L))
 *  H, height of the tree
 *  L, amount of nodes of the linked list
 *
 * Reference:
 * https://leetcode.com/problems/linked-list-in-binary-tree/discuss/535370/Java-KMP-Search-O(m%2Bn)-Clean-code
 */
@Suppress(UNUSED)
class SolutionApproach0DFSWithKMP {
    fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
        val pattern = toArray(head)
        val kmpTable = buildKMPTable(pattern)

        return dfs(0, root, pattern, kmpTable)
    }

    private fun dfs(index: Int, node: TreeNode?, pattern: IntArray, kmpTable: IntArray): Boolean {
        val nNums = pattern.size
        var idx = index

        if (idx == nNums) return true
        if (node == null) return false

        val value = node.`val`

        while (idx > 0 && value != pattern[idx]) {
            idx = kmpTable[idx - 1]
        }
        if (value == pattern[idx]) ++idx

        return dfs(idx, node.left, pattern, kmpTable) || dfs(idx, node.right, pattern, kmpTable)
    }

    private fun buildKMPTable(pattern: IntArray): IntArray {
        val nNums = pattern.size
        val kmpTable = IntArray(nNums) { 0 }

        var lo = 0
        var hi = 1

        while (hi < nNums) {
            when {
                pattern[lo] == pattern[hi] -> kmpTable[hi++] = ++lo
                lo == 0 -> ++hi
                else -> lo = kmpTable[lo - 1]
            }
        }

        return kmpTable
    }

    private fun toArray(head: ListNode?): IntArray {
        val res = mutableListOf<Int>()

        var cur = head

        while (cur != null) {
            res.add(cur.`val`)
            cur = cur.next
        }

        return res.toIntArray()
    }
}