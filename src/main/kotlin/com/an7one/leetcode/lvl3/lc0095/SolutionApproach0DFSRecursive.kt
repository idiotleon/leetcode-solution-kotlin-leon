package com.an7one.leetcode.lvl3.lc0095

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author: Leon
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31494/A-simple-recursive-solution/30203
 * https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31494/A-simple-recursive-solution
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun generateTrees(n: Int): List<TreeNode?> = dfs(1, n)

    private fun dfs(idxStart: Int, idxEnd: Int): List<TreeNode?> {
        val list = ArrayList<TreeNode?>()
        if (idxStart > idxEnd) list.add(null)

        for (idx in idxStart..idxEnd) {
            val leftList = dfs(idxStart, idx - 1)
            val rightList = dfs(idx + 1, idxEnd)
            for (left in leftList) {
                for (right in rightList) {
                    val root = TreeNode(idx)
                    root.left = left
                    root.right = right
                    list.add(root)
                }
            }
        }

        return list
    }
}