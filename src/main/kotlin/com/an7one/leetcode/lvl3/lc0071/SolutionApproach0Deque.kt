/**
 * https://leetcode.com/problems/simplify-path/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 *
 * References:
 *  https://leetcode.com/problems/simplify-path/discuss/25686/Java-10-lines-solution-with-stack/168182
 *  https://leetcode.com/problems/simplify-path/discuss/25686/Java-10-lines-solution-with-stack
 */
package com.an7one.leetcode.lvl3.lc0071

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Deque {
    fun simplifyPath(path: String): String {
        val skip = hashSetOf("..", ".", "")

        val deque = LinkedList<String>()
        for (str in path.split("/")) {
            when {
                !deque.isEmpty() && str == ".." -> deque.pop()
                !skip.contains(str) -> deque.push(str)
                else -> {
                }
            }
        }

        if (deque.isEmpty()) return "/"

        val builder = StringBuilder()
        while (!deque.isEmpty())
            builder.append("/").append(deque.pollLast())

        return builder.toString()
    }
}