package com.idiotleon.leetcode.lvl2.lc2379

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0SlidingWindow {
    private companion object {
        private const val WHITE = 'W'
        private const val BLACK = 'B'
    }

    fun minimumRecolors(blocks: String, k: Int): Int {
        val lenS = blocks.length

        var min = lenS
        var count = 0

        for ((hi, ch) in blocks.withIndex()) {
            if (ch == WHITE) {
                ++count
            }

            if (hi + 1 >= k) {
                min = minOf(min, count)
                val lo = hi - k + 1
                if (blocks[lo] == WHITE) {
                    --count
                }
            }
        }

        return min
    }
}