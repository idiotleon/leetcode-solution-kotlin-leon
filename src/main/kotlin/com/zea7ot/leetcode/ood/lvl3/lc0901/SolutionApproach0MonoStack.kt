/**
 * https://leetcode.com/problems/online-stock-span/
 *
 * Time Complexity:     O(N) ~ O(N ^ 2)
 * Space Complexity:    O(1) ~ O(N)
 *
 * to maintain a strictly "decreasing" order:
 *  1. the contents are an 2-element array of price and count
 *  2. the prices are strictly decreasing
 */
package com.zea7ot.leetcode.ood.lvl3.lc0901

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    private val stack = LinkedList<IntArray>()

    fun next(price: Int): Int {
        var span = 1

        while (stack.isNotEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1]
        }

        stack.push(intArrayOf(price, span))

        return span
    }
}