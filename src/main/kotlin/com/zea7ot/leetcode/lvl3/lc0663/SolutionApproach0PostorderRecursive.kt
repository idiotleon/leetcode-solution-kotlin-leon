/**
 * https://leetcode.com/problems/equal-tree-partition/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * References:
 *  https://leetcode.com/problems/equal-tree-partition/discuss/106727/JavaC%2B%2B-Simple-solution-with-only-one-HashMaplessgreater.
 */
package com.zea7ot.leetcode.lvl3.lc0663

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun checkEqualTree(root: TreeNode?): Boolean {
        val sumFreqs = HashMap<Int, Int>()

        val sum = postorder(root, sumFreqs)

        return if (sum == 0) (sumFreqs[sum] ?: 0) > 1
        else sum % 2 == 0 && sumFreqs.containsKey(sum / 2)
    }

    private fun postorder(node: TreeNode?, sumFreqs: HashMap<Int, Int>): Int {
        if (node == null) return 0

        val left = postorder(node.left, sumFreqs)
        val right = postorder(node.right, sumFreqs)

        val sum = left + right + node.`val`

        sumFreqs[sum] = 1 + (sumFreqs[sum] ?: 0)

        return sum
    }
}