/**
 * https://leetcode.com/problems/longest-happy-prefix/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/longest-happy-prefix/discuss/547446/C%2B%2BJava-with-picture-incremental-hash-and-KMP
 */
package com.an7one.leetcode.lvl4.lc1392

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0KMPAlgorithm {
    fun longestPrefix(str: String): String {
        val lenS = str.length

        val kmpTable = IntArray(lenS) { 0 }

        var hi = 1
        var lo = 0

        while (hi < lenS) {
            when {
                str[hi] == str[lo] -> kmpTable[hi++] = ++lo
                lo == 0 -> ++hi
                else -> lo = kmpTable[lo - 1]
            }
        }

        return str.substring(0, lo)
    }
}