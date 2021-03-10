/**
 * https://leetcode.com/problems/find-root-of-n-ary-tree/
 *
 * Time Complexity:     O(`nNodes`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/find-root-of-n-ary-tree/discuss/726453/Java-O(n)-time-with-O(n)-space-and-O(1)-space-follow-up
 */
package com.an7one.leetcode.lvl3.lc1506

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun findRoot(tree: List<Node>): Node? {
        // not used
        // val nNodes = tree.size

        var sum = 0

        for (node in tree) {
            sum = sum xor node.`val`

            for (child in node.children) {
                sum = sum xor child!!.`val`
            }
        }

        for (node in tree) {
            if (node.`val` == sum) return node
        }

        return null
    }
}