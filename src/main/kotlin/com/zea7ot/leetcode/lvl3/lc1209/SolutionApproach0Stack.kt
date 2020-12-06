/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/discuss/393149/JavaPython-3-O(n)-codes-using-Stack-w-brief-explanation-and-analysis.
 */
package com.zea7ot.leetcode.lvl3.lc1209

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack {
    fun removeDuplicates(str: String, k: Int): String {
        // not used
        // val lenS = str.length

        val stack = LinkedList<Node>()
        for (ch in str) {
            if (stack.isEmpty() || ch != stack.peek().ch) {
                stack.push(Node(ch, 1))
            } else {
                val (_, freq) = stack.pop()
                if (freq + 1 != k) stack.push(Node(ch, freq + 1))
            }
        }

        val builder = StringBuilder()
        while (stack.isNotEmpty()) {
            val (ch, freq) = stack.pop()

            for (repeat in 0 until freq) {
                builder.append(ch)
            }
        }

        return builder.reverse().toString()
    }

    private data class Node(val ch: Char, val freq: Int)
}