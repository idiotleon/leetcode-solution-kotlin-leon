/**
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/
 *
 * Time Complexity:     O((lg(`n`)) ^ 2)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/discuss/92242/ConciseEasy-to-understand-Java-5ms-solution-with-Explaination
 */
package com.zea7ot.leetcode.lvl4.lc0440

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DenaryTree {
    fun findKthNumber(n: Int, k: Int): Int {
        var cur = 1
        var k = k
        --k // to turn into 0-indexed
        while (k > 0) {
            val steps = calcSteps(cur.toLong(), (cur + 1).toLong(), n.toLong())
            if (steps <= k) {
                ++cur
                k -= steps
            } else {
                cur *= 10
                --k
            }
        }

        return cur
    }

    private fun calcSteps(num1: Long, num2: Long, n: Long): Int {
        var num1 = num1
        var num2 = num2

        var steps = 0L

        while (num1 <= n) {
            steps += minOf(n + 1, num2) - num1
            num1 *= 10
            num2 *= 10
        }

        return steps.toInt()
    }
}