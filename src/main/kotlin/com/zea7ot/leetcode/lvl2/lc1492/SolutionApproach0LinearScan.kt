/**
 * https://leetcode.com/problems/the-kth-factor-of-n/
 *
 * Time Complexity:     O(min(sqrt(`n`), `k`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/the-kth-factor-of-n/discuss/708099/C%2B%2BJava-Straightforward-%2B-Sqrt(n)
 */
package com.zea7ot.leetcode.lvl2.lc1492

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun kthFactor(n: Int, k: Int): Int {
        var count = k

        var factor = 1
        while (factor * factor <= n) {
            if (n % factor == 0 && --count == 0) {
                return factor
            }

            ++factor
        }

        for (d in factor - 1 downTo 1) {
            if (d * d == n) continue

            if (n % d == 0 && --count == 0) {
                return n / d
            }
        }

        return -1
    }
}