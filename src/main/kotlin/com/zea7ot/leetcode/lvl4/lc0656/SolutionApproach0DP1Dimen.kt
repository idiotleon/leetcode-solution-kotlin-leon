/**
 * https://leetcode.com/problems/coin-path/
 *
 * Time Complexity:     O(`nCoins` ^ 2)
 * Space Complexity:    O(`nCoins`)
 *
 * References:
 *  https://leetcode.com/problems/coin-path/discuss/106295/C++-DP-O(nB)-time-O(n)-space/108651
 *  https://leetcode.com/problems/coin-path/discuss/106295/C%2B%2B-DP-O(nB)-time-O(n)-space
 */
package com.zea7ot.leetcode.lvl4.lc0656

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun cheapestJump(coins: IntArray, maxJump: Int): List<Int> {
        val ans = mutableListOf<Int>()
        // sanity check
        if (coins.isEmpty() || coins.last() < 0) return ans
        val nCoins = coins.size

        val paths = IntArray(nCoins) { -1 }
        val costs = IntArray(nCoins) { Int.MAX_VALUE }.also {
            it[nCoins - 1] = coins[nCoins - 1]
        }

        for (lo in nCoins - 2 downTo 0) {
            if (coins[lo] == -1) continue

            var hi = lo + 1
            while (hi <= minOf(lo + maxJump, nCoins - 1)) {
                if (costs[lo] > costs[hi] + coins[lo] && costs[hi] != Int.MAX_VALUE) {
                    costs[lo] = costs[hi] + coins[lo]
                    paths[lo] = hi
                }

                ++hi
            }
        }

        if (costs[0] == Int.MAX_VALUE) return ans

        // to retrieve the path
        var k = 0
        while (k != -1) {
            ans.add(k + 1)
            k = paths[k]
        }

        return ans
    }
}