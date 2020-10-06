package com.zea7ot.leetcode.lvl2.lv1120

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.data_structure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun maximumAverageSubtree(root: TreeNode?): Double {
        return postorder(root).average
    }

    private fun postorder(node: TreeNode?): Result {
        node?.let {
            val left = postorder(it.left)
            val right = postorder(it.right)

            val sum = left.sum + right.sum + it.`val`
            val count = left.count + right.count + 1
            val average = sum.toDouble() / count
            // the max average among the parent and two children tree nodes
            val maxAverage = maxOf(average, left.average, right.average)

            return Result(sum, count, maxAverage)
        }

        return Result(0, 0, 0.0)
    }

    private data class Result(val sum: Int, val count: Int, val average: Double)

}