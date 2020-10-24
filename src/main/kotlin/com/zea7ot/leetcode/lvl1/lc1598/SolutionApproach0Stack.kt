/**
 * @author: Leon
 * https://leetcode.com/problems/crawler-log-folder/
 *
 * Time Complexity:     O(`totalLogs` * avgLenLog)
 * Space Complexity:    O(`totalLogs`)
 */
package com.zea7ot.leetcode.lvl1.lc1598

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val MOVE_TO_PARENT = "../"
        private const val REMAIN = "./"
    }

    fun minOperations(logs: Array<String>): Int {
        // not used
        // val totalLogs = logs.size

        val stack = LinkedList<String>()

        for (log in logs) {
            when (log) {
                MOVE_TO_PARENT -> if (stack.isNotEmpty()) stack.pop()
                REMAIN -> {
                    // to do nothing
                }
                else -> stack.push(log)
            }
        }

        return stack.size
    }
}