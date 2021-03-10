/**
 * https://leetcode.com/problems/remove-9/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/remove-9/discuss/106569/A-general-solution-in-java-useful-if-some-number-other-than-9-is-removed
 */
package com.an7one.leetcode.lvl4.lc0660.followup

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun newInteger(n: Int): Int {
        if (n < 9) return n

        // `dp[n]` corresponds to range [10 ^ (n - 1), 10 ^ n - 1]
        // e.g. dp[2] is the number of 9 within [10, 99]
        val dp = IntArray(10) { 0 }.also {
            it[0] = 0
            it[1] = 1
        }

        var p = 10
        for (idx in 2 until 10) {
            dp[idx] = dp[idx - 1] * 9 + p
            p *= 10
        }

        var lo = n
        var hi = Int.MAX_VALUE
        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            if (mid - numOf9s(mid, dp) >= n) {
                hi = mid - 1
            } else {
                lo = mid + 1
            }
        }

        return lo
    }

    private fun numOf9s(x: Int, dp: IntArray): Int {
        var res = 0
        var num = x
        var i = 0
        var p = 1

        while (num != 0) {
            val lastDigit = num % 10
            if (lastDigit == 9) {
                res = 9 * dp[i] + x % p + 1
            } else {
                res += lastDigit * dp[i]
            }
            ++i
            p *= 10
            num /= 10
        }
        return res
    }
}