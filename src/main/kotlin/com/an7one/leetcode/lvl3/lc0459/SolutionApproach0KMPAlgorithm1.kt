/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 */
package com.an7one.leetcode.lvl3.lc0459

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0KMPAlgorithm1 {
    fun repeatedSubstringPattern(str: String): Boolean {
        val seg = getRepeatedSegment(str)

        return seg.isNotEmpty()
    }


    private fun getRepeatedSegment(pattern: String): String {
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

        if (lo > 0 && lenP % (lenP - lo) == 0) return pattern.substring(0, lenP - lo)

        return ""
    }
}