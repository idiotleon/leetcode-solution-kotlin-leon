package com.idiotleon.summary.byAlgorithm.sort

import com.idiotleon.summary.byAlgorithm.sort.insertionSort.InsertionSort
import org.junit.Test
import kotlin.test.assertTrue

internal class InsertionSortTest {

    private val insertionSort = InsertionSort()

    @Test
    fun test_SampleInput1_ShouldReturnExpected() {
        val nums = intArrayOf(1, 2, 3, 8, 7, 6, 5)

        val sorted = nums.sorted().toIntArray()
        // val sorted = nums.copyOf().also { it.sort() }

        insertionSort.sort(nums)

        assertTrue(sorted contentEquals nums)
    }
}