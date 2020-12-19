/**
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
 *
 *
 */
package com.zea7ot.leetcode.lvl3.lc0255

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun verifyPreorder(preorder: IntArray): Boolean {
        if (preorder.isEmpty()) return true

        val idx = intArrayOf(0)

        return verify(idx, Int.MIN_VALUE, Int.MAX_VALUE, preorder)
    }

    private fun verify(idx: IntArray, min: Int, max: Int, preorder: IntArray): Boolean {
        val nNodes = preorder.size
        if (idx[0] == nNodes) return true

        val rootValue = preorder[idx[0]]
        if (rootValue < min || rootValue > max) return false

        ++idx[0]
        return verify(idx, min, rootValue - 1, preorder) || verify(idx, rootValue + 1, max, preorder)
    }
}