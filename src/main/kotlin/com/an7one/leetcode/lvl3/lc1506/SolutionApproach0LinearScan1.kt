/**
 * https://leetcode.com/problems/find-root-of-n-ary-tree/
 *
 * Time Complexity:     O(`nNodes`)
 * Space Complexity:    O(`nNodes`)
 *
 * References:
 *  https://leetcode.com/problems/find-root-of-n-ary-tree/discuss/726453/Java-O(n)-time-with-O(n)-space-and-O(1)-space-follow-up
 */
package com.an7one.leetcode.lvl3.lc1506

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun findRoot(tree: List<Node>): Node? {
        // not used
        // val nNodes = tree.size

        val seen = HashSet<Node>()

        for (node in tree) {
            for (child in node.children) {
                seen.add(child!!)
            }
        }

        for (node in tree) {
            if (!seen.contains(node)) return node
        }

        return null
    }
}