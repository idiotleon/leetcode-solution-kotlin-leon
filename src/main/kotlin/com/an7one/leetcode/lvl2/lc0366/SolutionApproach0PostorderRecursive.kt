/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 *  https://leetcode.com/problems/find-leaves-of-binary-tree/discuss/83778/10-lines-simple-Java-solution-using-recursion-with-explanation
 */
package com.an7one.leetcode.lvl2.lc0366

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun findLeaves(root: TreeNode?): List<List<Int>> {
        val ans = mutableListOf<MutableList<Int>>()
        postorder(root, ans)

        return ans
    }

    private fun postorder(
        node: TreeNode?,
        res: MutableList<MutableList<Int>>
    ): Int {

        if (node == null)
            return -1

        val level = 1 + maxOf(postorder(node.left, res), postorder(node.right, res))

        if (res.size < 1 + level)
            res.add(mutableListOf())

        res[level].add(node.`val`)
        return level
    }
}