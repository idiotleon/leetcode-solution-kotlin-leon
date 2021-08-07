/**
 * https://leetcode.com/problems/hamming-distance/
 *
 * Time Complexity:     O(bit(`num`))
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/hamming-distance/discuss/94698/Java-1-Line-Solution-%3AD
 *  https://tech.liuchao.me/2016/11/count-bits-of-integer/
 */
package com.an7one.leetcode.lvl2.lc0461.withBit

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BitManipulation {
    fun hammingDistance(x: Int, y: Int): Int = getHammingWeight(x xor y)

    private fun getHammingWeight(num: Int): Int {
        var num = num
        var count = 0
        while (num != 0) {
            count += (num and 1)
            num = num shr 1
        }

        return count
    }
}