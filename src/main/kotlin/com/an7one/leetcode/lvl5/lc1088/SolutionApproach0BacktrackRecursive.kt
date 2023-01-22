package com.an7one.leetcode.lvl5.lc1088

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/confusing-number-ii/
 *
 * Time Complexity:     O(len_of_n * 6) ~ O(len_of_n)
 * Space Complexity:    O(6) ~ O(1)
 *
 * Reference:
 * https://leetcode.com/problems/confusing-number-ii/discuss/446589/Easy-to-understand-Java-backtracking-solution-covers-edge-case
 */
@Suppress(UNUSED)
class SolutionApproach0BacktrackRecursive {
    private companion object {
        private val candidateToRotated: HashMap<Long, Long> =
            hashMapOf(0L to 0L, 1L to 1L, 6L to 9L, 8L to 8L, 9L to 6L)
    }

    fun confusingNumberII(n: Int): Int {
        val count = intArrayOf(0)
        backtrack(0L, n, count)
        return count[0]
    }

    private fun backtrack(numCur: Long, n: Int, count: IntArray) {
        if (isConfusing(numCur)) ++count[0]

        for ((candidate, _) in candidateToRotated) {
            val numNext = numCur * 10 + candidate
            if (numNext <= n && numNext != 0L) backtrack(numNext, n, count)
        }
    }

    private fun isConfusing(num: Long): Boolean {
        var src = num
        var strobogrammaticRotatedNumber = 0L
        while (src > 0) {
            strobogrammaticRotatedNumber = strobogrammaticRotatedNumber * 10 + (candidateToRotated[src % 10] ?: 0)
            src /= 10
        }

        // should not be the same as the original `num`
        return strobogrammaticRotatedNumber != num
    }
}