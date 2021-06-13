/**
 * https://leetcode.com/problems/maximum-number-of-removable-characters/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 *  https://leetcode.com/problems/maximum-number-of-removable-characters/discuss/1268477/JAVA-Binary-Search-with-Detailed-Explanation!
 */
package com.an7one.leetcode.lvl3.lc1898

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch1 {
    private companion object {
        private const val PLACE_HOLDER = '#'
    }

    fun maximumRemovals(s: String, p: String, removable: IntArray): Int {
        val lenR = removable.size

        val chs = s.toCharArray()

        var lo = 0
        var hi = lenR

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2

            for (idx in 0 until mid) {
                chs[removable[idx]] = PLACE_HOLDER
            }

            if (isSubsequence(chs, p))
                lo = mid + 1
            else {
                for (idx in 0 until mid) {
                    chs[removable[idx]] = s[removable[idx]]
                }

                hi = mid - 1
            }
        }

        return hi
    }

    private fun isSubsequence(chs: CharArray, str: String): Boolean {
        val sizeChs = chs.size
        val lenS = str.length

        var idxCh = 0
        var idxS = 0

        while (idxCh < sizeChs && idxS < lenS) {
            val ch = chs[idxCh]
            val chStr = str[idxS]

            if (ch != PLACE_HOLDER && ch == chStr)
                ++idxS

            ++idxCh
        }

        if (idxS == lenS)
            return true

        return false
    }
}