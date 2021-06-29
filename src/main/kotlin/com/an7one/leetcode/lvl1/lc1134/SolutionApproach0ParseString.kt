/**
 * @author: Leon
 * https://leetcode.com/problems/armstrong-number/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl1.lc1134

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.pow

@Suppress(UNUSED)
class SolutionApproach0ParseString {
    fun isArmstrong(n: Int): Boolean {
        val str = n.toString()
        val lenS = str.length

        var num = 0
        for (ch in str) {
            val digit = ch - '0'
            num += digit.toDouble().pow(lenS.toDouble()).toInt()
        }

        return num == n
    }
}