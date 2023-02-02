package com.an7one.leetcode.lvl5.lc0943.withBit

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/find-the-shortest-superstring/
 *
 * Time Complexity:     O((2 ^ `nStrs`) ^ 2)
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/find-the-shortest-superstring/discuss/194932/Travelling-Salesman-Problem/222214
 * https://leetcode.com/problems/find-the-shortest-superstring/discuss/194932/Travelling-Salesman-Problem
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun shortestSuperstring(strs: Array<String>): String {
        val nStrs = strs.size
        val graph = Array(nStrs) { IntArray(nStrs) { 0 } }
        for (i in strs.indices) {
            for (j in strs.indices) {
                graph[i][j] = getEdgeWeight(strs[i], strs[j])
                graph[j][i] = getEdgeWeight(strs[j], strs[i])
            }
        }

        val range = 1 shl nStrs
        val dp = Array(range) { IntArray(nStrs) { 0 } }
        val paths = Array(range) { IntArray(nStrs) { 0 } }

        var last = -1
        var min = Int.MAX_VALUE

        for (bitMask in 1 until range) { // current combination/bit mask
            dp[bitMask].fill(Int.MAX_VALUE)
            for (idxS in strs.indices) {
                if ((bitMask and (1 shl idxS)) > 0) { // if `strs[idxS]` has been taken before
                    val prev = bitMask - (1 shl idxS) // to retrieve its previous state
                    if (prev == 0) {
                        dp[bitMask][idxS] = strs[idxS].length
                    } else {
                        for (k in 0 until nStrs) {
                            if (dp[prev][k] < Int.MAX_VALUE && dp[prev][k] + graph[k][idxS] < dp[bitMask][idxS]) {
                                dp[bitMask][idxS] = dp[prev][k] + graph[k][idxS]
                                paths[bitMask][idxS] = k // to save the current path/state for later retrieval
                            }
                        }
                    }
                }

                if (bitMask == range - 1 && dp[bitMask][idxS] < min) {
                    min = dp[bitMask][idxS]
                    last = idxS
                }
            }
        }

        // to retrieve previous paths
        val builder = StringBuilder()
        var cur = range - 1
        val stack = LinkedList<Int>()
        while (cur > 0) {
            stack.push(last)
            val temp = cur
            cur -= (1 shl last)
            last = paths[temp][last]
        }

        // to build the (shortest) superstring
        var idx1 = stack.pop()
        builder.append(strs[idx1])
        while (stack.isNotEmpty()) {
            val idx2 = stack.pop()
            val word = strs[idx2]
            val lenW = word.length
            builder.append(word.substring(lenW - graph[idx1][idx2]))
            idx1 = idx2
        }

        return builder.toString()
    }

    private fun getEdgeWeight(a: String, b: String): Int {
        val lenA = a.length
        val lenB = b.length

        for (idx in 1 until lenA) {
            if (b.startsWith(a.substring(idx))) {
                return lenB - lenA + idx
            }
        }

        return lenB
    }
}