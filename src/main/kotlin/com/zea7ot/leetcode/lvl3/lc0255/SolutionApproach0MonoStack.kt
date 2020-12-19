/**
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
 *
 * Time Complexity:     O(`nNodes`)
 * Space Complexity:    O(`nNodes`)
 *
 * References:
 *  https://github.com/wisdompeak/LeetCode/blob/master/Tree/255.Verify-Preorder-Sequence-in-Binary-Search-Tree/255.Verify%20Preorder%20Sequence%20in%20Binary%20Search%20Tree_stack.cpp
 *  https://github.com/wisdompeak/LeetCode/tree/master/Tree/255.Verify-Preorder-Sequence-in-Binary-Search-Tree
 *  https://youtu.be/raHLlFKtsXw
 *  https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/discuss/68142/Java-O(n)-and-O(1)-extra-space
 */
package com.zea7ot.leetcode.lvl3.lc0255

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun verifyPreorder(preorder: IntArray): Boolean {
        // not used
        // val nNodes = preorder.size

        val stack = LinkedList<Int>()
        var small = Int.MIN_VALUE

        for (value in preorder) {
            if (value < small) return false

            while (stack.isNotEmpty() && value > stack.peek()) {
                small = stack.pop()
            }

            stack.push(value)
        }

        return true
    }
}