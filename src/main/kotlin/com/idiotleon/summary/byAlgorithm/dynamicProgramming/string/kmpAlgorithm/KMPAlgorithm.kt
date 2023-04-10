/**
 * @author: Leon
 *
 * Time Complexity:     O(`lenP`)
 * Space Complexity:    O(`lenP`) / O(1)
 *
 * References:
 *  Paid Course, 130min: https://www.acwing.com/video/15/
 */
package com.idiotleon.summary.byAlgorithm.dynamicProgramming.string.kmpAlgorithm

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class KMPAlgorithm {
    fun buildKMPTable(pattern: String): IntArray {
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