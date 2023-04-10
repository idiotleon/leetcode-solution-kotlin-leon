package com.idiotleon.leetcode.lvl3.lc0255

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
 *
 * Time Complexity:     O(`nNodes`)
 * Space Complexity:    O(`nNodes`)
 *
 * References:
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/discuss/68142/Java-O(n)-and-O(1)-extra-space/70002
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/discuss/68142/Java-O(n)-and-O(1)-extra-space
 * https://github.com/wisdompeak/LeetCode/tree/master/Tree/255.Verify-Preorder-Sequence-in-Binary-Search-Tree
 */
@Suppress(UNUSED)
class SolutionApproach0MonoStack1 {
    fun verifyPreorder(preorder: IntArray): Boolean {
        // not used
        // val nNodes = preorder.size

        val stack = ArrayDeque<Int>()
        val inorderStk = ArrayDeque<Int>()

        for (value in preorder) {
            if (inorderStk.isNotEmpty() && value < inorderStk.last()) return false

            while (stack.isNotEmpty() && value > stack.last()) {
                inorderStk.addLast(stack.removeLast())
            }

            stack.addLast(value)
        }

        return true
    }
}