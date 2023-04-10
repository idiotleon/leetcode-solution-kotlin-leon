/**
 * https://leetcode.com/problems/check-if-it-is-a-good-array/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/check-if-it-is-a-good-array/discuss/419532/Bezout's-identity-(GCD-calculation)
 *  https://leetcode.com/problems/check-if-it-is-a-good-array/discuss/419368/JavaC++Python-Chinese-Remainder-Theorem/378281
 *  https://leetcode.com/problems/check-if-it-is-a-good-array/discuss/419368/JavaC%2B%2BPython-Chinese-Remainder-Theorem
 */
package com.idiotleon.leetcode.lvl4.lc1250

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math2 {
    fun isGoodArray(nums: IntArray): Boolean {
        // not used
        // val totalNums = nums.size

        var gcdRes = nums[0]
        for (num in nums) gcdRes = gcd(gcdRes, num)

        return gcdRes == 1
    }

    private fun gcd(x: Int, y: Int): Int {
        var a = x
        var b = y

        while (b != 0) {
            val temp = b
            b = a % b
            a = temp
        }

        return a
    }
}