/**
 * https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 *  https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/discuss/1228845/Kotlin-2-pointers-with-comments
 */
package com.an7one.leetcode.lvl3.lc1868

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers0 {
    fun findRLEArray(encoded1: Array<IntArray>, encoded2: Array<IntArray>): List<List<Int>> {
        val len1 = encoded1.size
        val len2 = encoded2.size

        var idx1 = 0
        var idx2 = 0

        val ans = mutableListOf<MutableList<Int>>()

        while (idx1 < len1 && idx2 < len2) {
            val (product1, freq1) = encoded1[idx1]
            val (product2, freq2) = encoded2[idx2]

            val product = product1 * product2

            val freq = minOf(freq1, freq2)

            if (ans.isEmpty() || ans.last()[0] != product) {
                ans.add(mutableListOf(product, freq))
            } else {
                ans.last()[1] += freq
            }

            if (freq1 == freq) {
                ++idx1
            } else {
                encoded1[idx1][1] -= freq
            }

            if (freq2 == freq) {
                ++idx2
            } else {
                encoded2[idx2][1] -= freq
            }
        }

        return ans
    }
}