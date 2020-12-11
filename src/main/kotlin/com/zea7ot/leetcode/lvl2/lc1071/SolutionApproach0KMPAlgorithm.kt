/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 *
 * Time Complexity:     O(`len1` + `len2`) ~ O(max(`len1`, `len2`))
 * Space Complexity:    O(`len1` + `len2`) ~ O(max(`len1`, `len2`))
 */
package com.zea7ot.leetcode.lvl2.lc1071

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0KMPAlgorithm {
    fun gcdOfStrings(str1: String, str2: String): String {
        val len1 = str1.length
        val len2 = str2.length

        val seg1 = getRepeatedSegment(str1)
        val seg2 = getRepeatedSegment(str2)

        if (seg1 != seg2 || seg2.isEmpty()) return ""

        val lenSeg1 = seg1.length
        val lenSeg2 = seg2.length

        val a = len1 / lenSeg1
        val b = len2 / lenSeg2
        val gcd = gcd(a, b)

        return seg1.repeat(gcd)
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a
    else gcd(b, a % b)

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

        if (lo > 0) {
            val lenSeg = lenP - lo
            if (lenP % lenSeg == 0) return pattern.substring(0, lenSeg)
        }

        return pattern
    }
}