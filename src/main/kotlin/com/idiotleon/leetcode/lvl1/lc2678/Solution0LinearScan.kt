package com.idiotleon.leetcode.lvl1.lc2678

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-senior-citizens/
 *
 * Time Complexity:     O(`nDetails`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun countSeniors(details: Array<String>): Int {
        val nDetails = details.size

        var count = 0

        for (detail in details) {
            val age = (detail[11] - '0') * 10 + (detail[12] - '0')
            if (age > 60) {
                ++count
            }
        }

        return count
    }
}