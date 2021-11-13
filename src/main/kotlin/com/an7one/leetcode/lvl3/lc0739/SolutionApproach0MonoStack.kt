/**
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Time Complexity:     O(`totalT`)
 * Space Complexity:    O(`totalT`)
 *
 * to maintain a "non-increasing" stack
 * 1. the elements of the stack are indexes, instead of values
 * 2. the values in the given array, accessed by those indexes, are in non-increasing order
 */
package com.an7one.leetcode.lvl3.lc0739

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@OptIn(ExperimentalStdlibApi::class)
@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun dailyTemperatures(T: IntArray): IntArray {
        val nTs = T.size
        val stack = ArrayDeque<Int>()

        val ans = IntArray(nTs) { 0 }

        for (idx in T.indices) {
            while (stack.isNotEmpty() && T[stack.last()] < T[idx]) {
                val prevIdx = stack.removeLast()
                ans[prevIdx] = idx - prevIdx
            }

            stack.addLast(idx)
        }

        // by values, this can be omitted
        while (stack.isNotEmpty()) {
            ans[stack.removeLast()] = 0
        }

        return ans
    }
}