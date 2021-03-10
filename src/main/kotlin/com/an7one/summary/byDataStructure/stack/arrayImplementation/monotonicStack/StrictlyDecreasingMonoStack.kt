/**
 * @author: Leon
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * References:
 *  Paid Course, 87min: https://www.acwing.com/video/15/
 */
package com.an7one.summary.byDataStructure.stack.arrayImplementation.monotonicStack

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class StrictlyDecreasingMonoStack {
    private companion object {
        private const val DATA_RANGE = 1e6.toInt() + 7
    }

    private val stack = Array<Int?>(DATA_RANGE) { null }
    private var idx = 0

    fun main() {
        // number of inputs
        val nInputs = readLine()!!.toInt()

        for (input in 0 until nInputs) {
            // to read the input(s)
            val value = readLine()!!.toInt()

            while (idx > 0 && stack[idx]!! >= value) --idx

            stack[idx] = value
            ++idx
        }
    }
}