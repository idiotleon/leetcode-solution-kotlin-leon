/**
 * https://leetcode.com/problems/path-sum-iii/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * References:
 *  https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method
 */
package com.zea7ot.leetcode.lvl3.lc0437

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun pathSum(root: TreeNode?, sum: Int): Int {
        if (root == null) return 0

        val prefixSumToFreq = hashMapOf(0 to 1)
        return backtrack(0, sum, root, prefixSumToFreq)
    }

    private fun backtrack(curSum: Int, target: Int, node: TreeNode?, prefixSumToFreq: HashMap<Int, Int>): Int {
        if (node == null) return 0

        val value = node.`val`
        val nextSum = curSum + value

        var freq = prefixSumToFreq[nextSum - target] ?: 0

        prefixSumToFreq[nextSum] = 1 + (prefixSumToFreq[nextSum] ?: 0)
        freq += backtrack(nextSum, target, node.left, prefixSumToFreq) + backtrack(
            nextSum,
            target,
            node.right,
            prefixSumToFreq
        )
        prefixSumToFreq[nextSum] = (prefixSumToFreq[nextSum] ?: 1) - 1

        return freq
    }
}