/**
 * https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/discuss/247626/JavaPythonC%2B%2B-Stack-Solution-O(N)
 */
package com.zea7ot.leetcode.lvl3.lc1003

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack {
    fun isValid(str: String): Boolean {
        // not used
        // val lenS = str.length

        val stack = LinkedList<Char>()
        for (ch in str) {
            when (ch) {
                'c' -> {
                    if (stack.isEmpty() || stack.pop() != 'b') return false
                    if (stack.isEmpty() || stack.pop() != 'a') return false
                }

                else -> stack.push(ch)
            }
        }

        return stack.isEmpty()
    }
}