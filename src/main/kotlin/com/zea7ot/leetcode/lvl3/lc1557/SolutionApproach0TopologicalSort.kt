/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 */
package com.zea7ot.leetcode.lvl3.lc1557

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TopologicalSort {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val degrees = IntArray(n) { 0 }

        for (edge in edges) {
            val to = edge[1]
            ++degrees[to]
        }

        val ans = ArrayList<Int>()
        for (idx in degrees.indices) {
            if (degrees[idx] == 0) {
                ans.add(idx)
            }
        }

        return ans
    }
}