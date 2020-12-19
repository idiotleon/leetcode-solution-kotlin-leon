/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc0508

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        val sumToFreq = HashMap<Int, Int>()
        val maxCnt = intArrayOf(0)

        postorder(root, sumToFreq, maxCnt)

        val ans = mutableListOf<Int>()
        for ((sum, freq) in sumToFreq) {
            if (freq == maxCnt[0]) ans.add(sum)
        }

        return ans.toIntArray()
    }

    private fun postorder(
        node: TreeNode?,
        sumToFreq: HashMap<Int, Int>,
        maxCnt: IntArray
    ): Int {
        if (node == null) return 0

        val leftSum = postorder(node.left, sumToFreq, maxCnt)
        val rightSum = postorder(node.right, sumToFreq, maxCnt)
        val sum = leftSum + rightSum + node.`val`

        sumToFreq[sum] = 1 + (sumToFreq[sum] ?: 0)
        maxCnt[0] = maxOf(maxCnt[0], sumToFreq[sum] ?: 0)
        return sum
    }
}