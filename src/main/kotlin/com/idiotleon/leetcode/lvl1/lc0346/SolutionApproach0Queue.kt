/**
 * https://leetcode.com/problems/moving-average-from-data-stream/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(`size`)
 */
package com.idiotleon.leetcode.lvl1.lc0346

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Queue(private val size: Int) {
    private var sum = 0

    @OptIn(ExperimentalStdlibApi::class)
    private val queue = ArrayDeque<Int>()

    /** Initialize your data structure here. */

    fun next(`val`: Int): Double {
        sum += `val`
        queue.addLast(`val`)
        if (queue.size > size)
            sum -= queue.removeFirst()

        return sum.toDouble() / queue.size
    }
}