package com.idiotleon.leetcode.ood.lvl3.lc0901

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/online-stock-span/
 *
 * Time Complexity:     O(N) ~ O(N ^ 2)
 * Space Complexity:    O(1) ~ O(N)
 *
 * to maintain a strictly "decreasing" order:
 *  1. the contents are an 2-element array of price and count
 *  2. the prices are strictly decreasing
 */
@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    private val stack = ArrayDeque<IntArray>()

    fun next(price: Int): Int {
        var span = 1

        while (stack.isNotEmpty() && stack.last()[0] <= price) {
            span += stack.removeLast()[1]
        }

        stack.addLast(intArrayOf(price, span))

        return span
    }
}