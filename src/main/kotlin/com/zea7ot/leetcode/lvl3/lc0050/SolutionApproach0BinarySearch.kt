/**
 * https://leetcode.com/problems/powx-n/
 *
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.wang/leetCode-50-Pow.html
 *  https://leetcode.com/problems/powx-n/discuss/19563/Iterative-Log(N)-solution-with-Clear-Explanation
 *  https://leetcode.com/problems/powx-n/discuss/19563/Iterative-Log(N)-solution-with-Clear-Explanation/115437
 *  https://stackoverflow.com/questions/38922606/what-is-x-1-and-x-1
 */
package com.zea7ot.leetcode.lvl3.lc0050

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun myPow(x: Double, n: Int): Double {
        var ans = 1.0
        var absN = abs(n.toLong())
        var base = x

        while (absN > 0) {
            if ((absN and 1) == 1L) ans *= base

            absN /= 2
            base *= base
        }

        return if (n < 0) (1 / ans) else ans
    }
}