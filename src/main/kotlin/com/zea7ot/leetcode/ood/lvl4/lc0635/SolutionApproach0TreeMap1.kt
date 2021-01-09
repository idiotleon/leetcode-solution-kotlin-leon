/**
 * https://leetcode.com/problems/design-log-storage-system/
 *
 * Time Complexities:
 *  initialization:     O()
 *  put:                O()
 *  retrieve:           O()
 *
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/design-log-storage-system/discuss/105006/Java-range-query-using-TreeMap.subMap()/488137
 *  https://leetcode.com/problems/design-log-storage-system/discuss/105006/Java-range-query-using-TreeMap.subMap()
 */
package com.zea7ot.leetcode.ood.lvl4.lc0635

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0TreeMap1 {
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

        return retrieve(timeStart, timeEnd)
    }

    private fun retrieve(timeStart: String, timeEnd: String): List<Int> {
        val res = mutableListOf<Int>()

        for ((timestamp, logs) in logs) {
            if (timestamp in timeStart..timeEnd) {
                res.addAll(logs)
            }
        }

        return res
    }
}