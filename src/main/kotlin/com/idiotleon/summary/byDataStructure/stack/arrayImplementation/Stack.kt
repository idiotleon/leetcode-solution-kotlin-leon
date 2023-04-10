/**
 * @author: Leon
 *
 * References:
 *  Paid Course, 100min: https://www.acwing.com/video/15/
 */
package com.idiotleon.summary.byDataStructure.stack.arrayImplementation

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class Stack {
    private companion object {
        private const val DATA_RANGE = 1e6.toInt() + 7
    }

    private val stack = Array<Int?>(DATA_RANGE) { null }
    private var idx = 0

    /**
     *
     */
    fun push(value: Int) {
        stack[++idx] = value
    }

    /**
     *
     */
    fun pop(): Int {
        val value = stack[idx]!!
        --idx
        return value
    }

    /**
     *
     */
    fun peek(): Int {
        return stack[idx]!!
    }

    /**
     *
     */
    fun isNotEmpty(): Boolean {
        return idx > 0
    }

    /**
     *
     */
    fun isEmpty(): Boolean {
        return idx == 0
    }
}