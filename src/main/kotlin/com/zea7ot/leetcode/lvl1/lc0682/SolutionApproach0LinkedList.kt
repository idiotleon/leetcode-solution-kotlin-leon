/**
 * https://leetcode.com/problems/baseball-game/
 *
 * Time Complexity:     O(`totalOps`)
 * Space Complexity:    O(`totalOps`)
 *
 * References:
 *  https://leetcode.com/problems/baseball-game/discuss/107860/Verbose-Java-solution-LinkedList
 */
package com.zea7ot.leetcode.lvl1.lc0682

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0LinkedList {
    private companion object {
        private const val C = "C"
        private const val D = "D"
        private const val SIGN_PLUS = "+"
    }

    fun calPoints(ops: Array<String>): Int {
        var sum = 0
        val list = LinkedList<Int>()

        for (op in ops) {
            when (op) {
                C -> if (list.isNotEmpty()) sum -= list.removeLast()
                D -> {
                    list.addLast(list.peekLast() * 2)
                    sum += list.peekLast()
                }
                SIGN_PLUS -> {
                    list.addLast(list.peekLast() + list[list.size - 2])
                    sum += list.peekLast()
                }
                else -> {
                    list.add(op.toInt())
                    sum += list.peekLast()
                }
            }
        }

        return sum
    }
}