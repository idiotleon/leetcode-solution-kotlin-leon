/**
 * https://leetcode.com/problems/design-compressed-string-iterator/
 *
 * Time Complexities:
 *  initialization:     O(`lenS`)
 *  `next()`:           O(1)
 *  `hasNext()`:        O(1)
 *
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/design-compressed-string-iterator/discuss/103828/Java-Concise-Single-Queue-Solution
 */
package com.zea7ot.leetcode.ood.lvl3.lc0604

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Queue(private val compressedString: String) {
    private val lenS = compressedString.length
    private val queue = LinkedList<Node>()

    init {
        var lo = 0
        while (lo < lenS) {
            var hi = lo + 1
            var freq = 0
            while (hi < lenS && compressedString[hi] in '0'..'9') {
                freq = freq * 10 + (compressedString[hi] - '0')
                ++hi
            }
            queue.add(Node(compressedString[lo], freq))
            lo = hi
        }
    }

    fun next(): Char {
        if (queue.isEmpty()) return ' '
        val cur = queue.peek()
        if (--cur.freqs == 0) queue.poll()
        return cur.ch
    }

    fun hasNext(): Boolean = queue.isNotEmpty()

    private data class Node(val ch: Char, var freqs: Int)
}