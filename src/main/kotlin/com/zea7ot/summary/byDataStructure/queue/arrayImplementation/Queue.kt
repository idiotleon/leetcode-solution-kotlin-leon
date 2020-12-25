/**
 * @author: Leon
 *
 * References:
 *  Paid Course, 106min: https://www.acwing.com/video/15/
 */
package com.zea7ot.summary.byDataStructure.queue.arrayImplementation

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class Queue {
    private companion object {
        private const val DATA_RANGE = 1e6.toInt() + 7
    }

    private val queue = Array<Int?>(DATA_RANGE) { null }
    private var headIdx = 0
    private var tailIdx = 0

    /**
     *
     */
    fun add(newValue: Int) {
        queue[tailIdx] = newValue
        ++tailIdx
    }

    /**
     *
     */
    fun poll(): Int? {
        return if (isNotEmpty()) {
            val firstVal = queue[headIdx]!!
            ++headIdx
            firstVal
        } else null
    }

    fun poll1() = queue[headIdx++]

    /**
     *
     */
    fun peek(): Int? {
        return if (isNotEmpty()) queue[headIdx]!!
        else null
    }

    fun peek1() = queue[headIdx]

    /**
     *
     */
    fun isNotEmpty(): Boolean {
        return headIdx <= tailIdx
    }

    /**
     *
     */
    fun isEmpty(): Boolean {
        return headIdx > tailIdx
    }
}