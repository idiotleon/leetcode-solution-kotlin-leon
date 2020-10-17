/**
 * https://leetcode.com/problems/k-similar-strings/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/k-similar-strings/discuss/139872/Java-Backtracking-with-Memorization
 *  https://leetcode.com/problems/couples-holding-hands/discuss/113362/JavaC++-O(N)-solution-using-cyclic-swapping
 */
package com.zea7ot.leetcode.lvl4.lc0854

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun kSimilarity(A: String, B: String): Int {
        val memo = HashMap<String, Int>()
        return backtrack(0, A.toCharArray(), B, memo)
    }

    private fun backtrack(idx: Int, chs: CharArray, B: String, memo: HashMap<String, Int>): Int {
        val lenS = chs.size
        val lenB = B.length
        val str = String(chs)
        if (str == B) return 0

        memo[str]?.let { return it }

        var min = Int.MAX_VALUE
        var lo = idx
        while (lo < lenS && chs[lo] == B[lo]) {
            ++lo
        }

        for (hi in lo + 1 until lenB) {
            if (chs[hi] != B[lo]) continue
            swap(lo, hi, chs)
            val next = backtrack(idx + 1, chs, B, memo)
            if (next != Int.MAX_VALUE) {
                min = minOf(min, next + 1)
            }
            swap(lo, hi, chs)
        }

        memo[str] = min
        return min
    }

    private fun swap(lo: Int, hi: Int, chs: CharArray) {
        val temp = chs[lo]
        chs[lo] = chs[hi]
        chs[hi] = temp
    }
}