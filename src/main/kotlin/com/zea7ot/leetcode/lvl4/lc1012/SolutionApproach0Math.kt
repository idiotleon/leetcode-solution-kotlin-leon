/**
 * https://leetcode.com/problems/numbers-with-repeated-digits/
 *
 * Time Complexity:     O(lg(`N`))
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://leetcode.com/problems/numbers-with-repeated-digits/discuss/256725/JavaPython-Count-the-Number-Without-Repeated-Digit/251730
 *  https://leetcode.com/problems/numbers-with-repeated-digits/discuss/256725/JavaPython-Count-the-Number-Without-Repeated-Digit
 */
package com.zea7ot.leetcode.lvl4.lc1012

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun numDupDigitsAtMostN(N: Int): Int {
        val nums = mutableListOf<Int>()
        var padded = N + 1
        while (padded != 0) {
            nums.add(padded % 10)
            padded /= 10
        }
        nums.reverse()
        val nNums = nums.size

        // to count the number with digits < `N`
        var cntInvalid = 0
        for (idx in 0 until nNums - 1) {
            cntInvalid += 9 * permutate(9, idx)
        }

        // to count the number with the same prefix
        val isOccupied = BooleanArray(10) { false }
        for (idx in nums.indices) {
            val digit = nums[idx]

            var idxDigit = if (idx == 0) 1 else 0
            while (idxDigit < digit) {
                if (!isOccupied[idxDigit]) {
                    cntInvalid += permutate(10 - (idx + 1), nNums - idx - 1)
                }

                ++idxDigit
            }

            if (isOccupied[digit]) break
            isOccupied[digit] = true
        }

        return N - cntInvalid
    }

    private fun permutate(n: Int, c: Int): Int {
        var n = n
        var ans = 1

        for (i in 0 until c) {
            ans *= n
            --n
        }

        return ans
    }
}