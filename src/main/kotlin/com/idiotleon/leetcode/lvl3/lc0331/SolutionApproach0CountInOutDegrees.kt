package com.idiotleon.leetcode.lvl3.lc0331

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 *
 * Time Complexity:     O(`lenP`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution/188285
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution
 */
@Suppress(UNUSED)
class SolutionApproach0CountInOutDegrees {
    private companion object {
        private const val SPLITTER = ","
        private const val NULL_NODE = "#"
    }

    fun isValidSerialization(preorder: String): Boolean {
        // not used
        // val lenP = preorder.length

        val nodes = preorder.split(SPLITTER)

        var edges = 1
        for (node in nodes) {
            --edges // to consume one edge
            if (edges < 0) return false // to return false: [#,]
            if (node != NULL_NODE) edges += 2 // to generate 2 edges
        }

        return edges == 0
    }
}