/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/discuss/393149/JavaPython-3-O(n)-codes-using-Stack-w-brief-explanation-and-analysis.
 */
package com.idiotleon.leetcode.lvl3.lc1209

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack1 {
    fun removeDuplicates(str: String, k: Int): String {
        // not used
        // val lenS = str.length

        val chStack = LinkedList<Char>()
        val freqStack = LinkedList<Int>()

        for (ch in str) {
            if (chStack.isEmpty() || ch != chStack.peek()) {
                chStack.push(ch)
                freqStack.push(1)
            } else {
                val freq = (freqStack.pop() + 1) % k
                if (freq == 0) chStack.pop()
                else freqStack.push(freq)
            }
        }

        val builder = StringBuilder()
        while (freqStack.isNotEmpty()) {
            val freq = freqStack.pop()
            val ch = chStack.pop()

            for (repeat in 0 until freq) {
                builder.append(ch)
            }
        }

        return builder.reverse().toString()
    }
}