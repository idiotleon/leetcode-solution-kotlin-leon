package com.an7one.leetcode.lvl2.lc0028

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/implement-strstr/
 *
 * Time Complexity:     O(`lenH` + `lenN`) ~ O(max(`lenH`, `lenN`))
 * Space Complexity:    O(`lenN`)
 */
@Suppress(UNUSED)
class SolutionApproach0KMPAlgorithm {
    fun strStr(haystack: String, needle: String): Int {
        val lenH = haystack.length
        val lenN = needle.length

        val kmpTable = buildKMPTable(needle)

        var idxH = 0
        var idxN = 0

        while (idxH < lenH) {
            if (idxN == lenN)
                break

            when {
                haystack[idxH] == needle[idxN] -> {
                    ++idxH
                    ++idxN
                }

                idxN == 0 -> ++idxH

                else -> idxN = kmpTable[idxN - 1]
            }
        }

        if (idxN == lenN) return idxH - lenN

        return -1
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