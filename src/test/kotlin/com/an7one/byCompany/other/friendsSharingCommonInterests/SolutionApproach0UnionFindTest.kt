package com.an7one.byCompany.other.friendsSharingCommonInterests

import org.junit.Test
import kotlin.test.assertEquals


internal class SolutionApproach0UnionFindTest {

    private val solution = SolutionApproach0UnionFind()

    private val persons = arrayOf(
            Person(0, 1, 2),
            Person(1, 2, 3),
            Person(2, 4, 5),
            Person(3, 5, 6))


    @Test
    fun groupFriends_NormalInput1_ShouldReturnExpected() {
        val res = solution.groupFriends(persons)

        val expected = 2

        assertEquals(expected, res)
    }
}