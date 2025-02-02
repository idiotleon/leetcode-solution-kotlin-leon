package com.idiotleon.leetcode.lvl3.lc0071

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/simplify-path/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * Reference:
 * https://leetcode.com/problems/simplify-path/discuss/25686/Java-10-lines-solution-with-stack/168182
 * https://leetcode.com/problems/simplify-path/discuss/25686/Java-10-lines-solution-with-stack
 */
@Suppress(UNUSED)
class Solution0Deque {
    fun simplifyPath(path: String): String {
        val lenS = path.length
        val skip = hashSetOf("..", ".", "")

        val deque = ArrayDeque<String>()
        for (str in path.split("/")) {
            when {
                deque.isNotEmpty() && str == ".." -> deque.removeLast()
                !skip.contains(str) -> deque.addLast(str)
                else -> {
                }
            }
        }

        if (deque.isEmpty()) {
            return "/"
        }

        val builder = StringBuilder()
        while (deque.isNotEmpty()) {
            builder.append("/").append(deque.removeFirst())
        }

        return builder.toString()
    }
}