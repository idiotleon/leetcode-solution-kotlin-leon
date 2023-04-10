/**
 * https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/discuss/670917/Java-Greedy-by-TreeSet
 */
package com.idiotleon.leetcode.lvl3.lc1414

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0TreeSet {
    fun findMinFibonacciNumbers(K: Int): Int {
        if (K < 2) return K

        val treeset = TreeSet<Int>()
        var a = 0
        var b = 1
        while (b < K) {
            val temp = b
            b += a
            a = temp
            treeset.add(b)
        }

        var ans = 0
        var k = K
        while (k > 0) {
            val fib = treeset.floor(k)
            k -= fib
            ++ans
        }
        return ans
    }
}