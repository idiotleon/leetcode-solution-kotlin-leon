package com.an7one.leetcode.lvl3.lc0331

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 *
 * Time Complexity:     O(`lenP`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution/83284
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution/188285
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution
 */
@Suppress(UNUSED)
class SolutionApproach0CountInOutDegrees1 {
    private companion object {
        private const val SPLITTER = ","
        private const val NULL_NODE = "#"
    }

    fun isValidSerialization(preorder: String): Boolean {
        // not used
        // val lenP = preorder.length

        val nodes = preorder.split(SPLITTER)
        var indegree = 1
        var outdegree = 0

        for (node in nodes) {
            --indegree // to consume one edge
            if (outdegree + indegree < 0) return false // to return false: [#,]
            if (node != NULL_NODE) outdegree += 2 // to generate 2 edges
        }

        return indegree + outdegree == 0
    }
}