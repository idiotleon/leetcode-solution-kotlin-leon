/**
 * @author: Leon
 * https://leetcode.com/problems/crawler-log-folder/
 *
 * Time Complexity:     O(`nLogs` * avgLenLog)
 * Space Complexity:    O(`nLogs`)
 */
package com.an7one.leetcode.lvl1.lc1598

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.ArrayDeque

@Suppress(UNUSED)
class SolutionApproach0Stack {
    private companion object {
        private const val MOVE_TO_PARENT = "../"
        private const val REMAIN = "./"
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun minOperations(logs: Array<String>): Int {
        // not used
        // val nLogs = logs.size

        val stack = ArrayDeque<String>()

        for (log in logs) {
            when (log) {
                MOVE_TO_PARENT -> if (stack.isNotEmpty()) stack.removeFirst()
                REMAIN -> {
                    // to do nothing
                }
                else -> stack.addLast(log)
            }
        }

        return stack.size
    }
}