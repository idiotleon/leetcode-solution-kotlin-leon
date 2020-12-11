/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc0508

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        val freqs = HashMap<Int, Int>()
        val maxCnt = intArrayOf(0)

        postorder(root, freqs, maxCnt)

        val ans = ArrayList<Int>()
        for ((sum, freq) in freqs) {
            if (freq == maxCnt[0]) ans.add(sum)
        }

        return ans.toIntArray()
    }

    private fun postorder(node: TreeNode?,
                          freqs: HashMap<Int, Int>,
                          maxCnt: IntArray): Int {
        if (node == null) return 0

        val left = postorder(node.left, freqs, maxCnt)
        val right = postorder(node.right, freqs, maxCnt)
        val sum = left + right + node.`val`

        freqs[sum] = 1 + (freqs[sum] ?: 0)
        maxCnt[0] = maxOf(maxCnt[0], freqs[sum] ?: 0)
        return sum
    }
}