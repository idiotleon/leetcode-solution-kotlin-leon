/**
 * References:
 *  Paid Course, 11min: https://www.acwing.com/video/27/
 */
package com.zea7ot.summary.math.primeNumber

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DecompositionOfPrimeFactors {
    /**
     * Time Complexity:     O(`num`)
     * Space Complexity:    O(1)
     */
    fun getAllPrimeFactorsLinear(num: Int): List<Int> {
        val factors = mutableListOf<Int>()
        var num = num

        for (factor in 2..num) {
            if (num % factor == 0) { // must be a prime number
                var s = 0
                while (num % factor == 0) {
                    num /= factor
                    ++s
                }

                factors.add(factor)
            }
        }

        return factors
    }

    /**
     * Time Complexity:     O(sqrt(`num`)) in the worst case
     * Space Complexity:    O(1)
     */
    fun getAllPrimeFactorsLinearOptimized(num: Int): List<Int> {
        val factors = mutableListOf<Int>()
        var num = num

        var factor = 2
        while (factor <= num / factor) {
            if (num % factor == 0) {
                var s = 0
                while (num % factor == 0) {
                    num /= factor
                    ++s
                }

                factors.add(factor)
            }

            ++factor
        }

        if (num > 1) factors.add(factor)

        return factors
    }

    /**
     * Time Complexity:     O(`num` * ln(`num`)), ln = log e
     * Space Complexity:    O(`num`)
     */
/*    fun getAllPrimeFactorsSieveOfEratosthenes(num: Int): List<Int> {

    }*/

    /**
     * Time Complexity:     O(`num` * lg(lg(`num`)))
     * Space Complexity:    O(`num`)
     */
/*    fun getAllPrimeFactorsSieveOfEratosthenesOptimized(num: Int) {

    }*/

    /**
     * Time Complexity:     O()
     * Space Complexity:    O()
     *
     * `num`只会被最小质因子筛除掉
     */
    fun getAmountOfPrimeFactorsLinearSieve(num: Int): Int {
        val primes = IntArray(num + 1) { 0 }
        val isPrime = BooleanArray(num + 1) { false }
        var count = 0

        for (i in 2..num) {
            if (!isPrime[i]) primes[count++] = i

            var j = 0
            while (primes[j] <= num / i) {
                isPrime[primes[j] * i] = true
                if (i % primes[j] == 0) break // primes[j] must be the minimum prime number of `i`
                ++j
            }
        }

        return count
    }
}