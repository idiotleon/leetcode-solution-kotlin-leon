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
class Solution0LinearScan {
    fun largestGoodInteger(s: String): String {
        val lenS = s.length
        var idx = 2

        var largest = ""

        while (idx < lenS) {
            val first = s[idx - 2]
            val second = s[idx - 1]
            val third = s[idx]
            if (first == second && second == third) {
                val num = "$first$second$third"
                if (num > largest) {
                    largest = num
                }
            }

            ++idx
        }

        return largest
    }
}