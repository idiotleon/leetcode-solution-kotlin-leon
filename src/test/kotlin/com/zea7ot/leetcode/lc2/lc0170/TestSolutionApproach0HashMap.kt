package com.zea7ot.leetcode.lc2.lc0170

import com.zea7ot.leetcode.lvl2.lc0170.SolutionApproach0HashMap
import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0HashMap {
    private val solution = SolutionApproach0HashMap()

    @Test
    fun test() {
        val toAdds = arrayOf(0, 0)
        toAdds.forEach { num -> solution.add(num) }
        assertEquals(true, solution.find(0))
    }
}