package com.idiotleon.leetcode.ood.lvl3.lc0604

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/design-compressed-string-iterator/
 *
 * Time Complexities:
 *  initialization:     O(`lenS`)
 *  `next()`:           O(1)
 *  `hasNext()`:        O(1)
 *
 * Space Complexity:    O(`lenS`)
 *
 * Reference:
 * https://leetcode.com/problems/design-compressed-string-iterator/discuss/103828/Java-Concise-Single-Queue-Solution
 */
@Suppress(UNUSED)
class SolutionApproach0Queue(compressedString: String) {
    private val lenS = compressedString.length
    private val queue = ArrayDeque<Node>(lenS)

    init {
        var lo = 0
        while (lo < lenS) {
            var hi = 1 + lo
            var freq = 0
            while (hi < lenS && compressedString[hi] in '0'..'9') {
                freq = freq * 10 + (compressedString[hi] - '0')
                ++hi
            }
            queue.addLast(Node(compressedString[lo], freq))
            lo = hi
        }
    }

    fun next(): Char {
        if (queue.isEmpty()) {
            return ' '
        }
        val cur = queue.first()
        if (--cur.freqs == 0) {
            queue.removeFirst()
        }
        return cur.ch
    }

    fun hasNext(): Boolean = queue.isNotEmpty()

    private data class Node(val ch: Char, var freqs: Int)
}