/**
 * @author: Leon
 *
 * References:
 *  Paid Course: https://www.acwing.com/video/27/
 *  https://taodaling.github.io/blog/2020/06/14/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E7%AE%97%E6%B3%95/
 */
package com.zea7ot.summary.math.divisor

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DecompositionOfDivisors {
    /**
     * Time Complexity:     O(sqrt(`num`)) + O(nDivisors * lg(nDivisors)), nDivisor ~ lg(`num`) ~ O(sqrt(`num`))
     * Space Complexity:    O(nDivisors) / O(1)
     */
    fun getAllDivisorsLinearOptimized(num: Int): List<Int> {
        val divisors = mutableListOf<Int>()

        var factor = 1
        while (factor <= num / factor) {
            divisors.add(factor)
            if (factor != factor / num) {
                divisors.add(num / factor)
            }

            ++factor
        }

        divisors.sort()

        return divisors
    }

/*    fun getAmountOfAllDivisors(num: Int): Int {

    }*/

/*    fun getSumOfAllDivisors(num: Int): Int {


}
*/

    /**
     * Euclidean Algorithm
     * Greatest Common Divisor
     *
     * Time Complexity:     O(lg(`a` * `b`))
     * Space Complexity:    O()
     */
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    /**
     * Least Common Multiple
     *
     * Time Complexity:     O()
     * Space Complexity:    O()
     */
    fun lcm(a: Int, b: Int): Int = a / gcd(a, b) * b
}