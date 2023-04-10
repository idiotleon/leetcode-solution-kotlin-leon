/**
 * https://leetcode.com/problems/simplified-fractions/
 *
 * Time Complexity:     O((`n` ^ 2) * lg(`n`))
 * Space Complexity:    O(`n` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/simplified-fractions/discuss/635243/JavaPython-3-Use-GCD-to-judge-valid-fraction-w-analysis.
 */
package com.idiotleon.leetcode.lvl2.lc1447

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun simplifiedFractions(n: Int): List<String> {
        val ans = mutableListOf<String>()
        for (denominator in 2..n) {
            for (numerator in 1..denominator) {
                if (gcd(numerator, denominator) == 1) {
                    ans.add("$numerator/$denominator")
                }
            }
        }

        return ans
    }

    private fun gcd(x: Int, y: Int): Int = if (x == 0) y else gcd(y % x, x)
}