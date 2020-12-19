/**
 * https://leetcode.com/problems/validate-stack-sequences/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * References:
 *  https://leetcode.com/problems/validate-stack-sequences/discuss/197685/C%2B%2BJavaPython-Simulation-O(1)-Space
 */
package com.zea7ot.leetcode.lvl3.lc0946

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = LinkedList<Int>()

        var idx = 0
        for (num in pushed) {
            stack.push(num)

            while (stack.isNotEmpty() && stack.peek() == popped[idx]) {
                stack.pop()
                ++idx
            }
        }

        return stack.isEmpty()
    }
}