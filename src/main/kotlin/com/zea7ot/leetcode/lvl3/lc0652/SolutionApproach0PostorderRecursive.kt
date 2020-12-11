/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487527&idx=1&sn=9cf2b0d8608ba26ea7c6a5c9b41d05a1&chksm=9bd7ee2faca0673916bf075539bf6fc3c01f3dcc0b298b3f507047692ef5c850ed9cfe82e4e6&scene=21#wechat_redirect
 */
package com.zea7ot.leetcode.lvl3.lc0652

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    private companion object {
        private const val SPLITTER = ","
        private const val SEPARATOR = "#"
    }

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        val ans = mutableListOf<TreeNode>()
        val memo = HashMap<String, Int>()
        postorder(root, memo, ans)
        return ans
    }

    private fun postorder(node: TreeNode?, memo: HashMap<String, Int>, res: MutableList<TreeNode>): String {
        if (node == null) return SEPARATOR

        val left = postorder(node.left, memo, res)
        val right = postorder(node.right, memo, res)

        val value = node.`val`
        val hash = "$left$SPLITTER$value$SPLITTER$right$SEPARATOR"

        val freq = memo[hash] ?: 0

        if (freq == 1) res.add(node)

        memo[hash] = 1 + freq
        return hash
    }
}