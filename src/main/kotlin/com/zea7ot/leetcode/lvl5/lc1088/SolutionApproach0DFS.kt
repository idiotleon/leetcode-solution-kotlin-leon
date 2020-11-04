/**
 * https://leetcode.com/problems/confusing-number-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/confusing-number-ii/discuss/446589/Easy-to-understand-Java-backtracking-solution-covers-edge-case
 */
package com.zea7ot.leetcode.lvl5.lc1088

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFS {
    private companion object {
        private val map = hashMapOf(0 to 0, 1 to 1, 6 to 9, 8 to 8, 9 to 6)
    }

    fun confusingNumberII(N: Int): Int {
        val count = intArrayOf(0)
        dfs(0L, N, count)
        return count[0]
    }

    private fun dfs(curNum: Long, N: Int, count: IntArray) {
        if (isConfusingNum(curNum)) {
            ++count[0]
        }

        for ((candidate, _) in map) {
            val nextNum = curNum * 10 + candidate
            if (nextNum <= N && nextNum != 0L) {
                dfs(nextNum, N, count)
            }
        }
    }

    private fun isConfusingNum(num: Long): Boolean {
        var src = num
        var strobogrammaticRotatedNumber = 0
        while (src > 0) {
            strobogrammaticRotatedNumber = strobogrammaticRotatedNumber * 10 + (map[src.toInt() % 10] ?: 0)
            src /= 10
        }

        // should not be the same as the original `num`
        return strobogrammaticRotatedNumber.toLong() != num
    }
}