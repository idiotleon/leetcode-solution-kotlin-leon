package com.idiotleon.leetcode.ood.lvl5.lc1622

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/fancy-sequence/
 *
 * Time Complexities:
 *     `append()`:         O(1)
 *     `addAll()`:         O(1)
 *     `multiApp()`:       O(1)
 *     `getIndex()`:       O(1)
 *
 * Space Complexity:       O(N)
 *     N, number of calls of `append()`
 *
 * Reference:
 * https://leetcode.com/problems/fancy-sequence/discuss/898753/Python-Time-O(1)-for-each/736833
 * https://leetcode.com/problems/fancy-sequence/discuss/898753/Python-Time-O(1)-for-each
 */
@Suppress(UNUSED)
class SolutionApproach0PrefixSums {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    private val prefixSums = arrayListOf(0L)
    private val prefixProducts = arrayListOf(1L)
    private val nums = ArrayList<Int>()

    fun append(`val`: Int) {
        prefixSums.add(prefixSums.last())
        prefixProducts.add(prefixProducts.last())
        nums.add(`val`)
    }

    fun addAll(inc: Int) {
        prefixSums[prefixSums.lastIndex] = (prefixSums.last() + inc) % MOD
    }

    fun multAll(m: Int) {
        prefixSums[prefixSums.lastIndex] = (prefixSums.last() * m) % MOD
        prefixProducts[prefixProducts.lastIndex] = (prefixProducts.last() * m) % MOD
    }

    fun getIndex(idx: Int): Int {
        val nNums = nums.size
        if (idx >= nNums) {
            return -1
        }

        // Fermat Little Theorem
        val multi = prefixProducts.last() * powMod(prefixProducts[idx], MOD - 2L) % MOD

        val inc = prefixSums.last() + MOD - multi * prefixSums[idx] % MOD

        return ((multi * nums[idx].toLong() + inc) % MOD).toInt()
    }

    private fun powMod(xNum: Long, yNum: Long): Long {
        var res = 1L
        var x = xNum
        var y = yNum

        while (y > 0) {
            if (y % 2 == 1L) {
                res = res * x % MOD
            }

            x = x * x % MOD

            y /= 2
        }

        return res
    }
}