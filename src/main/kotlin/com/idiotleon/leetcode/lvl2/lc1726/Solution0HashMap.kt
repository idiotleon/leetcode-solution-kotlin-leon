package com.idiotleon.leetcode.lvl2.lc1726

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/tuple-with-same-product/
 *
 * Time Complexity:     O(`nNums` ^ 2)
 * Space Complexity:    O(`nNums` ^ 2)
 *
 * Reference:
 * https://leetcode.com/problems/tuple-with-same-product/editorial/
 */
@Suppress(UNUSED)
class Solution0HashMap {
    fun tupleSameProduct(nums: IntArray): Int {
        val nNums = nums.size
        val productToFreq = HashMap<Int, Int>(nNums * nNums).also {
            for (lo in 0 until nNums - 1) {
                for (hi in lo + 1 until nNums) {
                    val product = nums[lo] * nums[hi]
                    it[product] = (it[product] ?: 0) + 1
                }
            }
        }

        var total = 0
        for ((_, freq) in productToFreq) {
            val count = (freq - 1) * freq / 2
            total += 8 * count
        }

        return total
    }
}