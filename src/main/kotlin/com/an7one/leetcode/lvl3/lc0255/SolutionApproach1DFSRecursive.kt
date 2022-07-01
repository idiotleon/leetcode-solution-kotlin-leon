package com.an7one.leetcode.lvl3.lc0255

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
 *
 * Time Complexity:     O(`nNodes` ^ H)
 * Space Complexity:    O(`nNodes`)
 */
@Suppress(UNUSED)
class SolutionApproach1DFSRecursive {
    fun verifyPreorder(preorder: IntArray): Boolean {
        // not used
        // val nNodes = preorder.size

        return dfs(0, preorder.lastIndex, preorder)
    }

    private fun dfs(lo: Int, hi: Int, preorder: IntArray): Boolean {
        if (lo > hi) return true

        val rootValue = preorder[lo]

        var idx = lo + 1
        while (idx <= hi && preorder[idx] < rootValue) {
            ++idx
        }

        for (index in idx..hi) {
            if (preorder[index] <= rootValue) return false
        }

        return dfs(lo + 1, idx - 1, preorder) && dfs(idx, hi, preorder)
    }
}