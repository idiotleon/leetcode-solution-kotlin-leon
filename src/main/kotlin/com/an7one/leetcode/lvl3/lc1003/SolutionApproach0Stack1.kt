/**
 * https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/discuss/263378/Java-Easy-understanding-solution
 */
package com.an7one.leetcode.lvl3.lc1003

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack1 {
    fun isValid(str: String): Boolean {
        // not used
        // val lenS = str.length

        val stack = LinkedList<Char>()

        for (ch in str) {
            when (ch) {
                'a' -> {
                    stack.push('c')
                    stack.push('b')
                }

                else -> {
                    if (stack.isEmpty() || stack.pop() != ch) return false
                }
            }
        }

        return stack.isEmpty()
    }
}