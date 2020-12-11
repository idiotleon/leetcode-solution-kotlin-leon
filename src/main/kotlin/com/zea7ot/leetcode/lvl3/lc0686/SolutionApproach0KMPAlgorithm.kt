/**
 * https://leetcode.com/problems/repeated-string-match/
 *
 * Time Complexity:     O(`len1` + `len2`) ~ O(max(`len1`, `len2`))
 * Space Complexity:    O(`len2`)
 */
package com.zea7ot.leetcode.lvl3.lc0686

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0KMPAlgorithm {
    fun repeatedStringMatch(str1: String, str2: String): Int {
        val len1 = str1.length
        val len2 = str2.length

        val kmpTable = buildKMPTable(str2)

        var idx1 = 0
        var idx2 = 0
        var count = 0

        while (idx2 < len2) {
            when {
                idx1 == len1 -> {
                    ++count
                    idx1 = 0
                }

                str1[idx1] == str2[idx2] -> {
                    ++idx1
                    ++idx2
                }

                (count - 1) * len1 + idx1 > idx2 -> return -1

                idx2 == 0 -> ++idx1

                else -> idx2 = kmpTable[idx2 - 1]
            }
        }

        return 1 + count
    }

    private fun buildKMPTable(pattern: String): IntArray {
        val lenP = pattern.length

        val kmpTable = IntArray(lenP) { 0 }

        var lo = 0
        var hi = 1

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