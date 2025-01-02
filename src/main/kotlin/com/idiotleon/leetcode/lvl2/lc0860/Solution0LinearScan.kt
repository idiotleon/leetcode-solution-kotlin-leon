package com.idiotleon.leetcode.lvl2.lc0860

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/lemonade-change/
 *
 * Time Complexity:     O(`nBills`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun lemonadeChange(bills: IntArray): Boolean {
        val nBills = bills.size

        var countFive = 0
        var countTen = 0
        var countTwenty = 0

        for (bill in bills) {
            when (bill) {
                5 -> {
                    ++countFive
                }

                10 -> {
                    if (countFive == 0) {
                        return false
                    }

                    ++countTen
                    --countFive
                }

                20 -> {
                    if (countTen > 0 && countFive > 0) {
                        ++countTwenty
                        --countFive
                        --countTen
                    } else if (countFive >= 3) {
                        ++countTwenty
                        countFive -= 3
                    } else {
                        return false
                    }
                }

                else -> {

                }
            }
        }

        return true
    }
}