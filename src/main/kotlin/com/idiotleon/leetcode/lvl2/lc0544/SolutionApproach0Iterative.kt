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
 *  https://leetcode.com/problems/output-contest-matches/discuss/101226/Java-10-lines/104980
 *  https://leetcode.com/problems/output-contest-matches/discuss/101226/Java-10-lines
 */
@Suppress(UNUSED)
class SolutionApproach0Iterative {
    fun findContestMatch(n: Int): String {
        var deque = LinkedList<String>().also {
            for (num in 1..n) it.addLast(num.toString())
        }

        while (deque.size > 1) {
            val nextDeque = LinkedList<String>()
            while (deque.isNotEmpty()) {
                nextDeque.addLast("(${deque.pollFirst()},${deque.pollLast()})")
            }

            deque = nextDeque
        }

        return deque.poll()
    }
}