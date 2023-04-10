/**
 * https://leetcode.com/problems/the-kth-factor-of-n/
 *
 * Time Complexity:     O(min(`n`, `k`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/the-kth-factor-of-n/discuss/708099/C%2B%2BJava-Straightforward-%2B-Sqrt(n)
 */
package com.idiotleon.leetcode.lvl2.lc1492

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun kthFactor(n: Int, k: Int): Int {
        var count = k

        for (factor in 1..n / 2) {
            if (n % factor == 0 && --count == 0) {
                return factor
            }
        }

        return if (count == 1) n else -1
    }
}