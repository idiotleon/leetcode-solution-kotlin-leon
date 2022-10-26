package com.an7one.leetcode.lvl3.lc0743

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/network-delay-time/
 *
 * Time Complexity:     O(`nVertices` ^ 3)
 * Space Complexity:    O(`nVertices` ^ 2)
 *
 * Reference:
 * https://leetcode-cn.com/problems/network-delay-time/solution/dan-yuan-zui-duan-lu-po-su-de-dijkstra-dui-you-hua/
 */
@Suppress(UNUSED)
class SolutionApproach2FloydWarshall {
    private companion object {
        private const val DATA_RANGE = 100 + 1
    }

    fun networkDelayTime(times: Array<IntArray>, nVertices: Int, initial: Int): Int {
        val dp = Array(nVertices) { IntArray(nVertices) { DATA_RANGE } }.also {
            for (idx in 0 until nVertices) {
                it[idx][idx] = 0
            }
        }

        for ((start, end, time) in times) {
            dp[start - 1][end - 1] = minOf(dp[start - 1][end - 1], time)
        }

        for (k in 0 until nVertices) {
            for (i in 0 until nVertices) {
                for (j in 0 until nVertices) {
                    dp[i][j] = minOf(dp[i][j], dp[i][k] + dp[k][j])
                }
            }
        }

        var ans = 0
        for (idx in 0 until nVertices) {
            ans = maxOf(ans, dp[initial - 1][idx])
        }

        return if (ans == DATA_RANGE) -1 else ans
    }
}