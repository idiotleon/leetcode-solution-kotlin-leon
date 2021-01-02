package com.zea7ot.summary.byAlgorithm.sort.quickSort.byNumOfWays.oneWay

import com.zea7ot.util.UtilSort
import org.junit.Test
import kotlin.test.assertTrue

internal class QuickSort1WayTest {
    private val quickSort1Way = QuickSort1Way()

    @Test
    fun test_SampleInput1_ShouldBeSorted() {
        val list = mutableListOf(1, 2, 8, 6, 3, 2).also { it.shuffle() }

        val sorted = list.toIntArray().also { quickSort1Way.quickSort(it) }
        assertTrue(UtilSort.isSortedAscending(sorted.toTypedArray()))
    }
}