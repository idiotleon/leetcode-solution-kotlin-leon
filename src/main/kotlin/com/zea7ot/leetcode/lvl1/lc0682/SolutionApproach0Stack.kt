/**
 * https://leetcode.com/problems/baseball-game/
 *
 * Time Complexity:     O(`totalOps`)
 * Space Complexity:    O(`totalOps`)
 *
 * References:
 *  https://leetcode.com/problems/baseball-game/discuss/107860/Verbose-Java-solution-LinkedList/110022
 */
package com.zea7ot.leetcode.lvl1.lc0682

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val C = "C"
        private const val D = "D"
        private const val SIGN_PLUS = "+"
    }

    fun calPoints(ops: Array<String>): Int {
        // not used
        // val totalOps = ops.size

        var sum = 0
        val stack = LinkedList<Int>()

        for (op in ops) {
            when (op) {
                C -> if (stack.isNotEmpty()) sum -= stack.pop()
                D -> {
                    stack.push(stack.peek() * 2)
                    sum += stack.peek()
                }
                SIGN_PLUS -> {
                    val second = stack.peek()
                    stack.pop()
                    val first = stack.peek()
                    val cur = first + second
                    stack.push(second)
                    stack.push(cur)
                    sum += cur
                }
                else -> {
                    stack.push(op.toInt())
                    sum += stack.peek()
                }
            }
        }

        return sum
    }
}