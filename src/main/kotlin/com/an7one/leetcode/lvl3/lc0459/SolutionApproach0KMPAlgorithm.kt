/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 */
package com.an7one.leetcode.lvl3.lc0459

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0KMPAlgorithm {
    fun repeatedSubstringPattern(str: String): Boolean {
        val lenS = str.length
        val kmpTable = buildKMPTable(str)

        return kmpTable.last() != 0 && (lenS % (lenS - kmpTable.last())) == 0
    }

    private fun buildKMPTable(pattern: String): IntArray {
        val lenP = pattern.length

        val kmpTable = IntArray(lenP) { 0 }

        var hi = 1
        var lo = 0

        while (hi < lenP) {
            when {
                pattern[lo] == pattern[hi] -> kmpTable[hi++] = ++lo
                lo == 0 -> ++hi
                else -> lo = kmpTable[lo - 1]
            }
        }

        return kmpTable
    }
}