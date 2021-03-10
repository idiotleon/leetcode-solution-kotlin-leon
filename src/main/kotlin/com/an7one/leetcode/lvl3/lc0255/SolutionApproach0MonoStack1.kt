/**
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
 *
 * Time Complexity:     O(`nNodes`)
 * Space Complexity:    O(`nNodes`)
 *
 * References:
 *  https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/discuss/68142/Java-O(n)-and-O(1)-extra-space/70002
 *  https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/discuss/68142/Java-O(n)-and-O(1)-extra-space
 *  https://github.com/wisdompeak/LeetCode/tree/master/Tree/255.Verify-Preorder-Sequence-in-Binary-Search-Tree
 */
package com.an7one.leetcode.lvl3.lc0255

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack1 {
    fun verifyPreorder(preorder: IntArray): Boolean {
        // not used
        // val nNodes = preorder.size

        val stack = LinkedList<Int>()
        val inorderStk = LinkedList<Int>()

        for (value in preorder) {
            if (inorderStk.isNotEmpty() && value < inorderStk.peek()) return false

            while (stack.isNotEmpty() && value > stack.peek()) {
                inorderStk.push(stack.pop())
            }

            stack.push(value)
        }

        return true
    }
}