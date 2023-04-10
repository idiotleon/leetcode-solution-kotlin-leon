/**
 * https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/
 *
 * Time Complexity:     O(`len`)
 * Space Complexity:    O(`len`)
 *
 * Reference:
 *  https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/discuss/1231200/Java-two-pointer
 */
package com.idiotleon.leetcode.lvl3.lc1868

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers1 {
    fun findRLEArray(encoded1: Array<IntArray>, encoded2: Array<IntArray>): List<List<Int>> {
        val len1 = encoded1.size
        val len2 = encoded2.size

        var idx1 = 0
        var idx2 = 0

        val list = mutableListOf<List<Int>>()

        while (idx1 < len1 && idx2 < len2) {
            val (product1, freq1) = encoded1[idx1]
            val (product2, freq2) = encoded2[idx2]

            val product = product1 * product2

            when {
                freq1 == freq2 -> {
                    list.add(listOf(product, freq1))
                    ++idx1
                    ++idx2
                }

                freq1 < freq2 -> {
                    list.add(listOf(product, freq1))
                    encoded2[idx2][1] = freq2 - freq1
                    ++idx1
                }

                else -> {
                    list.add(listOf(product, freq2))
                    encoded1[idx1][1] = freq1 - freq2
                    ++idx2
                }
            }
        }

        val ans = mutableListOf<List<Int>>()
        val len = list.size

        var lo = 0
        var hi = 1

        while (hi <= len) {
            val (product, freq) = list[lo]
            var sumFreq = freq
            while (hi < len && product == list[hi][0]) {
                sumFreq += list[hi][1]
                ++hi
            }

            ans.add(listOf(product, sumFreq))

            lo = hi
            ++hi
        }

        return ans
    }
}