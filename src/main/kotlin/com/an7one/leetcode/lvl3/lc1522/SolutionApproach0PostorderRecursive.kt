package com.an7one.leetcode.lvl3.lc1522

import com.an7one.leetcode.util.Constant

/**
 * https://leetcode.com/problems/diameter-of-n-ary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/diameter-of-n-ary-tree/discuss/750352/Java-Simpler-and-Cleaner-DFS-recursion
 */
@Suppress(Constant.Annotation.UNUSED)
class SolutionApproach0PostorderRecursive {
    fun diameter(root: Node?): Int {
        val (_, maxDiameter) = postorder(root)
        return maxDiameter
    }

    private fun postorder(node: Node?): Res {
        if (node == null)
            return Res(0, 0)

        var maxDiameter = 0
        var maxDepth = 0
        var secMaxDepth = 0

        for (child in node.children) {
            val (maxDep, maxDia) = postorder(child)
            maxDiameter = maxOf(maxDiameter, maxDia)
            if (maxDep > maxDepth) {
                secMaxDepth = maxDepth
                maxDepth = maxDep
            } else if (maxDep > secMaxDepth) {
                secMaxDepth = maxDep
            }
        }

        return Res(1 + maxDepth, maxOf(maxDiameter, maxDepth + secMaxDepth))
    }

    private data class Res(val maxDepth: Int, val maxDiameter: Int)
}