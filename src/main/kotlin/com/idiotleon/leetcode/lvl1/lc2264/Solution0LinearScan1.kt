package com.idiotleon.leetcode.lvl1.lc2264

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan1 {
    fun largestGoodInteger(s: String): String {
        val lenS = s.length
        var idx = 2

        var largest = -1
        var ans = ""

        while (idx < lenS) {
            val one = s[idx - 2]
            val two = s[idx - 1]
            val three = s[idx]
            if (one == two && two == three) {
                val num = getNum(one, two, three)
                if (num > largest) {
                    largest = num
                    ans = "$one$two$three"
                }
            }

            ++idx
        }

        return ans
    }

    private fun getNum(one: Char, two: Char, three: Char): Int = (one - '0') * 100 + (two - '0') * 10 + (three - '0')
}