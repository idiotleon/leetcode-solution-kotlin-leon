/**
 * Time Complexities:
 *  `update()`:             O(lg(nTreeNodes))
 *  `query()`:              O(lg(nTreeNodes))
 *
 * Space Complexity:        O(nTreeNodes)
 *
 * References:
 *  https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76674/3-Ways-(Segment-Tree-Binary-Indexed-Tree-Merge-Sort)-clean-Java-code
 */
package com.zea7ot.summary.byDataStructure.tree.binaryIndexedTree.slimVersion

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class BinaryIndexedTree {

    fun update(index: Int, fenwick: IntArray) {
        val nBits = fenwick.size
        var idx = index

        while (idx < nBits) {
            ++fenwick[idx]
            idx += (idx and -idx)
        }
    }

    fun query(index: Int, fenwick: IntArray): Int {
        var sum = 0

        var idx = index
        while (idx > 0) {
            sum += fenwick[idx]
            idx -= (idx and -idx)
        }

        return sum
    }
}