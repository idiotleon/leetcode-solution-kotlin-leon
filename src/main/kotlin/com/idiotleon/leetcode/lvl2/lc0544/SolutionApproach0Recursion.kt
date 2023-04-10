package com.idiotleon.leetcode.lvl2.lc0544

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/output-contest-matches/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/output-contest-matches/discuss/101226/Java-10-lines/104981
 *  https://leetcode.com/problems/output-contest-matches/discuss/101226/Java-10-lines
 */
@Suppress(UNUSED)
class SolutionApproach0Recursion {
    fun findContestMatch(n: Int): String {
        val deque = LinkedList<String>().also {
            for (num in 1..n) it.addLast(num.toString())
        }

        return dfs(deque)
    }

    private fun dfs(deque: LinkedList<String>): String {
        if (deque.size == 1) return deque.pollFirst()

        val nextDeque = LinkedList<String>()
        while (deque.isNotEmpty()) {
            nextDeque.addLast("(${deque.pollFirst()},${deque.pollLast()})")
        }

        return dfs(nextDeque)
    }
}