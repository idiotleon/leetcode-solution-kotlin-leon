/**
 * this solution is not yet correct
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://zxi.mytechroad.com/blog/greedy/leetcode-1520-maximum-number-of-non-overlapping-substrings/
 */
package com.zea7ot.leetcode.lvl5.lc1520

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach4Greedy {
    fun maxNumOfSubstrings(str: String): List<String> {
        // not used
        // val lenS = str.length

        val firstIdxes = IntArray(26) { Int.MAX_VALUE }
        val lastIdxes = IntArray(26) { Int.MIN_VALUE }
        for (idx in str.indices) {
            firstIdxes[str[idx] - 'a'] = minOf(firstIdxes[str[idx] - 'a'], idx)
            lastIdxes[str[idx] - 'a'] = maxOf(lastIdxes[str[idx] - 'a'], idx)
        }

        val ans = ArrayList<String>()
        var prev = -1
        for (lo in str.indices) {
            if (lo != firstIdxes[str[lo] - 'a']) continue
            val hi = extend(lo, firstIdxes, lastIdxes, str)
            if (hi == -1) continue
            if (lo > prev) ans.add("")
            ans[ans.lastIndex] = str.substring(lo, hi - lo + 1)
            prev = hi
        }

        return ans
    }

    private fun extend(
        startIdx: Int,
        firstIdxes: IntArray,
        lastIdxes: IntArray,
        str: String
    ): Int {
        var endIdx = lastIdxes[str[startIdx] - 'a']

        for (idx in startIdx..endIdx) {
            if (firstIdxes[str[idx] - 'a'] < startIdx) return -1
            endIdx = maxOf(endIdx, lastIdxes[str[idx] - 'a'])
        }

        return endIdx
    }
}