/**
 * https://leetcode.com/problems/baseball-game/
 *
 * Time Complexity:     O(`nOps`)
 * Space Complexity:    O(`nOps`)
 *
 * References:
 *  https://leetcode.com/problems/baseball-game/discuss/107860/Verbose-Java-solution-LinkedList/110022
 */
package com.idiotleon.leetcode.lvl1.lc0682

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.collections.ArrayDeque

@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val C = "C"
        private const val D = "D"
        private const val SIGN_PLUS = "+"
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun calPoints(ops: Array<String>): Int {
        // not used
        // val nOps = ops.size

        var sum = 0
        val stack = ArrayDeque<Int>()

        for (op in ops) {
            when (op) {
                C -> if (stack.isNotEmpty()) sum -= stack.removeLast()
                D -> {
                    stack.addLast(stack.last() * 2)
                    sum += stack.last()
                }
                SIGN_PLUS -> {
                    val second = stack.last()
                    stack.removeLast()
                    val last = stack.last()
                    val cur = last + second
                    stack.addLast(second)
                    stack.addLast(cur)
                    sum += cur
                }
                else -> {
                    stack.addLast(op.toInt())
                    sum += stack.last()
                }
            }
        }

        return sum
    }
}