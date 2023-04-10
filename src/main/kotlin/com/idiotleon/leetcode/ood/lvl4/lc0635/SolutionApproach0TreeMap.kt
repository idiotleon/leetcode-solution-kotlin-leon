package com.idiotleon.leetcode.ood.lvl4.lc0635

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap

/**
 * @author: Leon
 * https://leetcode.com/problems/design-log-storage-system/
 *
 * Time Complexities:
 *  initialization:     O()
 *  put:                O()
 *  retrieve:           O()
 *
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/design-log-storage-system/discuss/105006/Java-range-query-using-TreeMap.subMap()
 */
@Suppress(UNUSED)
class SolutionApproach0TreeMap {
    private companion object {
        private const val LOWER_BOUND = "2000:01:01:00:00:00"
        private const val UPPER_BOUND = "2017:12:31:23:59:59"

        private const val GRANU_YEAR = "Year"
        private const val GRANU_MONTH = "Month"
        private const val GRANU_DAY = "Day"
        private const val GRANU_HOUR = "Hour"
        private const val GRANU_MINUTE = "Minute"
        private const val GRANU_SECOND = "Second"
    }

    private val granuToIdx = HashMap<String, Int>()
    private val logs = TreeMap<String, MutableList<Int>>()

    init {
        granuToIdx[GRANU_YEAR] = 4
        granuToIdx[GRANU_MONTH] = 7
        granuToIdx[GRANU_DAY] = 10
        granuToIdx[GRANU_HOUR] = 13
        granuToIdx[GRANU_MINUTE] = 16
        granuToIdx[GRANU_SECOND] = 19
    }

    fun put(id: Int, timestamp: String) {
        logs.getOrPut(timestamp) { mutableListOf() }.add(id)
    }

    fun retrieve(start: String, end: String, granularity: String): List<Int> {
        val idx = granuToIdx[granularity]!!

        val timeStart = start.substring(0, idx) + LOWER_BOUND.substring(idx)
        val timeEnd = end.substring(0, idx) + UPPER_BOUND.substring(idx)

        val subMap = logs.subMap(timeStart, true, timeEnd, true)

        val ans = mutableListOf<Int>()
        for ((_, logs) in subMap) {
            ans.addAll(logs)
        }

        return ans
    }
}